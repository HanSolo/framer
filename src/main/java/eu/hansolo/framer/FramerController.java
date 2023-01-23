package eu.hansolo.framer;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.micronaut.http.HttpHeaders.CACHE_CONTROL;
import static eu.hansolo.toolbox.Constants.*;


@Controller("/framer/v1.0/")
public class FramerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FramerController.class);

    /**
     * Returns a json document that contains data related to field of view and depth of field. You need to pass in values for the camera location and subject
     * location in WGS84 coordinates (latitude, longitude), the focal length of your lens in millimeter (e.g. 400), the aperture of your lens in f/stop (e.g. 4.5),
     * the sensor format of your camera (e.g. full_format, aps_c) and the orientation of the shot (landscape or portrait). From this values the service will calculate
     * the distance from the camera to the subject, the field of view (width, height) and the depth of field (area before and behind the subject etc.).
     * All distances are either in millimeter (sensor_width, sensor_height, focal_length) or in meter (distance_to_subject, hyper_focal_distance, fov_width, fov_height, dof_near_limit, dof_far_limit, dof_total)
     * All angles are given in degrees (fov_width_angle, fov_height_angle)
     *
     * @param latitude1 The latitude of the camera location
     * @param longitude1 The longitude of the camera location
     * @param latitude2 The latitude of the subject location
     * @param longitude2 The longitude of the subject location
     * @param focal_length The focal length of the used lens (8 - 2400 [mm])
     * @param aperture The aperture of the used lens (0.7 - 99 [f-stop])
     * @param sensor_format The sensor format (medium_format, full_format, aps_h, aps_c, aps_c_canon, micro_4_3)
     * @param orientation The orientation (landscape, portrait)
     * @return A json object that contains data related to field of view and depth of field. In addition it contains two geometries (triangle of fov and trapezoid of dof)
     */
    @Version("1")
    @Get("/calc_fov{?latitude1,longitude1,latitude2,longitude2,focal_length,aperture,sensor_format,orientation}")
    @Produces(MediaType.APPLICATION_JSON)
    @Header(name=CACHE_CONTROL,value="no-cache")
    @Operation(summary = "Returns a json document that contains data related to field of view and depth of field. \n\nYou need to pass in values for the camera location and subject location in WGS84 coordinates (latitude, longitude), \n\nthe focal length of your lens in millimeter (e.g. 400), \n\nthe aperture of your lens in f/stop (e.g. 4.5), \n\nthe sensor format of your camera (e.g. full_format, aps_c) and \n\nthe orientation of the shot (landscape or portrait).",
               description = "The service will calculate the distance from the camera to the subject, \n\nthe field of view (width, height) and \n\nthe depth of field (area before and behind the subject etc.).\n\nAll distances are either in millimeter (sensor_width, sensor_height, focal_length) or in meter (distance_to_subject, hyper_focal_distance, fov_width, fov_height, dof_near_limit, dof_far_limit, dof_total).\n\nAll angles are given in degrees (fov_width_angle, fov_height_angle)")
    public HttpResponse<?> calcFoV(@Parameter(description="The latitude coordinate of the camera location") @Nullable final Double latitude1,
                                   @Parameter(description="The longitude coordinate of the camera location") @Nullable final Double longitude1,
                                   @Parameter(description="The latitude coordinate of the subject location") @Nullable final Double latitude2,
                                   @Parameter(description="The longitude coordinate of the subject location") @Nullable final Double longitude2,
                                   @Parameter(description="The focal length of the used lens (8 - 2400 [mm])") @Nullable final Integer focal_length,
                                   @Parameter(description="The aperture of the used lens (0.7 - 99.0 [f-stop]") @Nullable final Double aperture,
                                   @Parameter(description="The sensor format of your camera (medium_format, full_format, aps_h, aps_c, aps_c_canon, micro_4_3)") @Nullable final String sensor_format,
                                   @Parameter(description="The orientation (landscape, portrait)") @Nullable final String orientation,
                                   final HttpRequest request) {
        final double lat1         = null == latitude1    ? 0   : latitude1;
        final double lon1         = null == longitude1   ? 0   : longitude1;
        final double lat2         = null == latitude2    ? 0   : latitude2;
        final double lon2         = null == longitude2   ? 0   : longitude2;
        final int    focalLength  = null == focal_length ? 50  : focal_length;
        final double apert        = null == aperture     ? 2.8 : aperture;
        SensorFormat sensorFormat = SensorFormat.fromText(sensor_format);
        Orientation  orient       = Orientation.fromText(orientation);

        if (SensorFormat.NOT_FOUND == sensorFormat) { sensorFormat = SensorFormat.FULL_FORMAT; }
        if (Orientation.NOT_FOUND  == orient)       { orient       = Orientation.LANDSCAPE; }

        final GeoLocation cameraLocation  = new GeoLocation(lat1, lon1);
        final GeoLocation subjectLocation = new GeoLocation(lat2, lon2);
        try {
            final FovData      fovData  = Helper.calc(cameraLocation, subjectLocation, focalLength, apert, sensorFormat, orient);
            final HttpResponse response = HttpResponse.ok(fovData.toString()).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
            return response;
        } catch (Exception e) {
            final String msg = FovData.getErrorMessage(e.getMessage());
            final HttpResponse response = HttpResponse.badRequest(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.BAD_REQUEST);
            return response;
        }
    }


    /**
     * Converts the given focal length and aperture by the given teleconverter
     * @param focal_length The focal length of the lens in mm (24, 35, 45, 50, 70, 85, 105, 200 etc.)
     * @param aperture The aperture of the lens in 1/3 stop increments (f1_0, f1_1, f1_2, f1_4, f1_6, f1_8, f2_0 etc.)
     * @param tc The used teleconverter (tc_1_4, tc_2_0)
     * @return A JSON document that contains the given focal length, aperture and teleconverter plus the converted focal length and aperture
     */
    @Version("1")
    @Get("/calc_tc{?focal_length,aperture,tc}")
    @Produces(MediaType.APPLICATION_JSON)
    @Header(name=CACHE_CONTROL,value="no-cache")
    @Operation(summary = "Converts the given focal length and aperture by the given teleconverter")
    public HttpResponse<?> calcTc(@Parameter(description="The focal length of the lens in mm (24, 35, 45, 50, 70, 85, 105, 200 etc.)") @Nullable final Integer focal_length,
                                  @Parameter(description="The aperture of the lens in 1/3 stop increments (f1_0, f1_1, f1_2, f1_4, f1_6, f1_8, f2_0 etc.)") @Nullable final String aperture,
                                  @Parameter(description="The used teleconverter (tc_1_4, tc_2_0)") @Nullable final String tc,
                                  final HttpRequest request) {
        int           focalLength   = (null == focal_length || focal_length < 8 || focal_length > 2400) ? 50                   : focal_length;
        Aperture      apert         = (null == aperture)                                                ? Aperture.F_2_8       : Aperture.fromText(aperture);
        TeleConverter teleConverter = (null == tc)                                                      ? TeleConverter.TC_1_4 : TeleConverter.fromText(tc);

        if (Aperture.NOT_FOUND == apert) { apert = Aperture.F_2_8; }
        if (TeleConverter.NOT_FOUND == teleConverter) { teleConverter = TeleConverter.TC_1_4; }

        int    convertedFocalLength = (int) (teleConverter.factor * focalLength);
        double convertedAperture    = TeleConverter.TC_1_4 == teleConverter ? apert.aperture_tc_1_4 : apert.aperture_tc_2_0;

        final String msg = new StringBuilder().append(CURLY_BRACKET_OPEN)
                                              .append(QUOTES).append("focal_length").append(QUOTES).append(COLON).append(focalLength).append(COMMA)
                                              .append(QUOTES).append("aperture").append(QUOTES).append(COLON).append(QUOTES).append(apert.apiString).append(QUOTES).append(COMMA)
                                              .append(QUOTES).append("tc").append(QUOTES).append(COLON).append(QUOTES).append(teleConverter.apiString).append(QUOTES).append(COMMA)
                                              .append(QUOTES).append("converted_focal_length").append(QUOTES).append(COLON).append(convertedFocalLength).append(COMMA)
                                              .append(QUOTES).append("converted_aperture").append(QUOTES).append(COLON).append(Helper.round(convertedAperture, 1))
                                              .append(CURLY_BRACKET_CLOSE)
                                              .toString();
        final HttpResponse response = HttpResponse.ok(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
        return response;
    }


    /**
     * Calculates the Exposure Value (EV) from the given aperture, shutter speed and iso values
     * @param aperture The aperture of the lens in 1/3 stop increments (f1_0, f1_1, f1_2, f1_4, f1_6, f1_8, f2_0 etc.)
     * @param shutter_speed The shutter speed in seconds (sp_1_1000, sp_1_500, sp_1, sp_30 etc.)
     * @param iso The used iso (iso_64, iso_100, iso_400, etc.)
     * @return A JSON document that contains the calculated exposure value and the given aperture, shutter speed and iso
     */
    @Version("1")
    @Get("/calc_tc{?aperture,shutter_speed,iso}")
    @Produces(MediaType.APPLICATION_JSON)
    @Header(name=CACHE_CONTROL,value="no-cache")
    @Operation(summary = "Converts the given focal length and aperture by the given teleconverter")
    public HttpResponse<?> calcEv(@Parameter(description="The aperture of the lens in 1/3 stop increments (f1_0, f1_1, f1_2, f1_4, f1_6, f1_8, f2_0 etc.)") @Nullable final String aperture,
                                  @Parameter(description="The shutter speed in seconds (sp_1_1000, sp_1_500, sp_1, sp_30 etc.)") @Nullable final String shutter_speed,
                                  @Parameter(description="The used iso (iso_64, iso_100, iso_400, etc.)") @Nullable final String iso,
                                  final HttpRequest request) {
        Aperture     apert        = (null == aperture)      ? Aperture.F_2_8        : Aperture.fromText(aperture);
        ShutterSpeed shutterSpeed = (null == shutter_speed) ? ShutterSpeed.SP_1_125 : ShutterSpeed.fromText(shutter_speed);
        ISO          i            = (null == iso)           ? ISO.ISO_100           : ISO.fromText(iso);

        if (Aperture.NOT_FOUND     == apert)        { apert        = Aperture.F_2_8; }
        if (ShutterSpeed.NOT_FOUND == shutterSpeed) { shutterSpeed = ShutterSpeed.SP_1_125; }
        if (ISO.NOT_FOUND          == i)            { i            = ISO.ISO_100; }

        EV ev = Helper.calcExposureValue(apert, shutterSpeed, i);

        final String msg = new StringBuilder().append(CURLY_BRACKET_OPEN)
                                              .append(QUOTES).append("aperture").append(QUOTES).append(COLON).append(QUOTES).append(apert.apiString).append(QUOTES).append(COMMA)
                                              .append(QUOTES).append("shutter_speed").append(QUOTES).append(COLON).append(QUOTES).append(shutterSpeed.apiString).append(QUOTES).append(COMMA)
                                              .append(QUOTES).append("iso").append(QUOTES).append(COLON).append(QUOTES).append(i.apiString).append(QUOTES).append(COMMA)
                                              .append(QUOTES).append("exposure_value").append(QUOTES).append(COLON).append(QUOTES).append(ev.apiString).append(QUOTES)
                                              .append(CURLY_BRACKET_CLOSE)
                                              .toString();
        final HttpResponse response = HttpResponse.ok(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
        return response;
    }


    /**
     * Returns a json document that contains a list of common apertures used in photography in steps of 1/3
     * @return a json document that contains a list of common apertures used in photography in steps of 1/3
     */
    @Version("1")
    @Get("/apertures")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Returns a list of common apertures used in photography in steps of 1/3")
    public HttpResponse<?> getApertures(final HttpRequest request) {
        final List<Aperture> apertures = Arrays.stream(Aperture.values()).toList();
        final String         msg       = new StringBuilder().append(apertures.stream().filter(aperture -> Aperture.NOT_FOUND != aperture).map(aperture -> aperture.toString()).collect(Collectors.joining(COMMA, SQUARE_BRACKET_OPEN, SQUARE_BRACKET_CLOSE))).toString();
        final HttpResponse   response  = HttpResponse.ok(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
        return response;
    }

    /**
     * Returns a json document that contains a list of common iso values
     * @return a json document that contains a list of common iso values
     */
    @Version("1")
    @Get("/isos")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Returns a list of common iso values used in photography")
    public HttpResponse<?> getIsos(final HttpRequest request) {
        final List<ISO>    isos     = Arrays.stream(ISO.values()).toList();
        final String       msg      = new StringBuilder().append(isos.stream().filter(iso -> ISO.NOT_FOUND != iso).map(iso -> iso.toString()).collect(Collectors.joining(COMMA, SQUARE_BRACKET_OPEN, SQUARE_BRACKET_CLOSE))).toString();
        final HttpResponse response = HttpResponse.ok(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
        return response;
    }

    /**
     * Returns a json document that contains a list of common shutter speeds
     * @return a json document that contains a list of common shutter speeds
     */
    @Version("1")
    @Get("/shutterspeeds")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Returns a list of common shutter speeds used in photography")
    public HttpResponse<?> getShutterSpeeds(final HttpRequest request) {
        final List<ShutterSpeed> shutterSpeeds = Arrays.stream(ShutterSpeed.values()).toList();
        final String             msg           = new StringBuilder().append(shutterSpeeds.stream().filter(shutterSpeed -> ShutterSpeed.NOT_FOUND != shutterSpeed).map(shutterSpeed -> shutterSpeed.toString()).collect(Collectors.joining(COMMA, SQUARE_BRACKET_OPEN, SQUARE_BRACKET_CLOSE))).toString();
        final HttpResponse       response      = HttpResponse.ok(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
        return response;
    }

    /**
     * Returns a json document that contains a list of common sensors used in photography
     * @return a json document that contains a list of common sensors used in photography
     */
    @Version("1")
    @Get("/sensors")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Returns a list of common sensors used in photography")
    public HttpResponse<?> getSensors(final HttpRequest request) {
        final List<SensorFormat> sensorFormats = Arrays.stream(SensorFormat.values()).toList();
        final String             msg           = new StringBuilder().append(sensorFormats.stream().filter(sensorFormat -> SensorFormat.NOT_FOUND != sensorFormat).map(sensorFormat -> sensorFormat.toString()).collect(Collectors.joining(COMMA, SQUARE_BRACKET_OPEN, SQUARE_BRACKET_CLOSE))).toString();
        final HttpResponse       response      = HttpResponse.ok(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
        return response;
    }

    /**
     * Returns a json document that contains a list of common teleconverters used in photography
     * @return a json document that contains a list of common teleconverters used in photography
     */
    @Version("1")
    @Get("/teleconverters")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Returns a list of common teleconverters used in photography")
    public HttpResponse<?> getTeleConverters(final HttpRequest request) {
        final List<TeleConverter> teleConverters = Arrays.stream(TeleConverter.values()).toList();
        final String              msg            = new StringBuilder().append(teleConverters.stream().filter(teleConverter -> TeleConverter.NOT_FOUND != teleConverter).map(teleConverter -> teleConverter.toString()).collect(Collectors.joining(COMMA, SQUARE_BRACKET_OPEN, SQUARE_BRACKET_CLOSE))).toString();
        final HttpResponse        response       = HttpResponse.ok(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
        return response;
    }
}