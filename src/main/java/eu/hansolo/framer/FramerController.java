package eu.hansolo.framer;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * Example:
     * {
     *    "camera_latitude":51.9120268350476,
     *    "camera_longitude":7.6338728239553495,
     *    "subject_latitude":51.911510620555674,
     *    "subject_longitude":7.632810650837488,
     *    "sensor_format":"full_format",
     *    "sensor_width":36.0,
     *    "sensor_height":23.9,
     *    "focal_length":400,
     *    "aperture":4.5,
     *    "orientation":"landscape",
     *    "distance_to_subject":92.96,
     *    "hyper_focal_distance":1226.45,
     *    "fov_width":8.36,
     *    "fov_height":5.57,
     *    "fov_width_angle":0.09,
     *    "fov_height_angle":0.06,
     *    "dof_near_limit":86.43,
     *    "dof_far_limit":100.55,
     *    "dof_total":14.12,
     *    "features":[
     *       {
     *          "type":"Feature",
     *          "geometry":{
     *             "type":"Polygon",
     *             "coordinates":[
     *                [
     *                   [
     *                      51.9120268350476,
     *                      7.6338728239553495
     *                   ],
     *                   [
     *                      51.91286189809355,
     *                      7.63381198393061
     *                   ],
     *                   [
     *                      51.91286189809355,
     *                      7.633933663980064
     *                   ]
     *                ]
     *             ]
     *          },
     *          "properties":{
     *             "name":"fovTriangle"
     *          }
     *       },
     *       {
     *          "type":"Feature",
     *          "geometry":{
     *             "type":"Polygon",
     *             "coordinates":[
     *                [
     *                   [
     *                      51.912803281607204,
     *                      7.633816254614454
     *                   ],
     *                   [
     *                      51.91293008757662,
     *                      7.6338070157628275
     *                   ],
     *                   [
     *                      51.91293008757662,
     *                      7.633938632147846
     *                   ],
     *                   [
     *                      51.912803281607204,
     *                      7.633929393296321
     *                   ]
     *                ]
     *             ]
     *          },
     *          "properties":{
     *             "name":"dofTrapezoid"
     *          }
     *       }
     *    ],
     *    "msg":""
     * }
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
    @Get("/calc{?latitude1,longitude1,latitude2,longitude2,focal_length,aperture,sensor_format,orientation}")
    @Produces(MediaType.APPLICATION_JSON)
    @Header(name=CACHE_CONTROL,value="no-cache")
    public HttpResponse<?> calcFoV(@Nullable final Double latitude1, @Nullable final Double longitude1, @Nullable final Double latitude2, @Nullable final Double longitude2, @Nullable final Integer focal_length, @Nullable final Double aperture, @Nullable final String sensor_format, @Nullable final String orientation, final HttpRequest request) {
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
            final Data         data     = Helper.calc(cameraLocation, subjectLocation, focalLength, apert, sensorFormat, orient);
            final HttpResponse response = HttpResponse.ok(data.toString()).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
            return response;
        } catch (Exception e) {
            final String msg = Data.getErrorMessage(e.getMessage());
            final HttpResponse response = HttpResponse.badRequest(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.BAD_REQUEST);
            return response;
        }
    }


    /**
     * Converts the given focal length and f/stop by the given teleconverter
     * @param focal_length The focal length of the lens in mm (24, 35, 45, 50, 70, 85, 105, 200 etc.)
     * @param fstop The f stop of the lens in 1/3 stop increments (f1_0, f1_1, f1_2, f1_4, f1_6, f1_8, f2_0 etc.)
     * @param tc The used teleconverter (tc_1_4, tc_2_0)
     * @return A JSON document that contains the given focal length, f/stop and teleconverter plus the converted focal length and f/stop
     */
    @Version("1")
    @Get("/tc{?focal_length,fstop,tc}")
    @Produces(MediaType.APPLICATION_JSON)
    @Header(name=CACHE_CONTROL,value="no-cache")
    public HttpResponse<?> tc(@Nullable final Integer focal_length, @Nullable final Double fstop, @Nullable final String tc, final HttpRequest request) {
        Integer       focalLength   = (null == focal_length || focal_length < 8 || focal_length > 2400) ? 50                   : focal_length;
        FStop         fStop         = (null == fstop)                                                   ? FStop.F_2_8          : FStop.fromNumber(fstop);
        TeleConverter teleConverter = (null == tc)                                                      ? TeleConverter.TC_1_4 : TeleConverter.fromText(tc);

        if (FStop.NOT_FOUND         == fStop)         { fStop         = FStop.F_2_8; }
        if (TeleConverter.NOT_FOUND == teleConverter) { teleConverter = TeleConverter.TC_1_4; }

        Integer convertedFocalLength = (int) (teleConverter.factor * focalLength);
        double  convertedFStop       = TeleConverter.TC_1_4 == teleConverter ? fStop.fstop_tc_1_4 : fStop.fstop_tc_2_0;

        final String msg = new StringBuilder().append(CURLY_BRACKET_OPEN)
                                              .append(QUOTES).append("focal_length").append(QUOTES).append(COLON).append(focalLength).append(COMMA)
                                              .append(QUOTES).append("f_stop").append(QUOTES).append(COLON).append(fStop.apiString).append(COMMA)
                                              .append(QUOTES).append("tc").append(QUOTES).append(COLON).append(teleConverter.apiString).append(COMMA)
                                              .append(QUOTES).append("focal_length").append(QUOTES).append(COLON).append(focalLength).append(COMMA)
                                              .append(QUOTES).append("converted_focal_length").append(QUOTES).append(COLON).append(convertedFocalLength).append(COMMA)
                                              .append(QUOTES).append("converted_f_stop").append(QUOTES).append(COLON).append(convertedFStop)
                                              .append(CURLY_BRACKET_CLOSE)
                                              .toString();
        final HttpResponse response = HttpResponse.ok(msg).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
        return response;
    }
}