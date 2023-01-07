package eu.hansolo.framer;

import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import static io.micronaut.http.HttpHeaders.CACHE_CONTROL;


@Controller("/framer")
public class FramerController {

    /**
     * Returns a json format that contains data related to field of view and depth of field.
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
     *    ]
     * }
     * @param latitude1 The latitude of the camera location
     * @param longitude1 The longitude of the camera location
     * @param latitude2 The latitude of the subject location
     * @param longitude2 The longitude of the subject location
     * @param focal_length The focal length of the used lens
     * @param aperture The aperture of the used lens
     * @param sensor_format The sensor format (medium_format, full_format, aps_h, aps_c, aps_c_canon, micro_4_3)
     * @param orientation The orientation (landscape, portrait)
     * @param request
     * @return A json object that contains data related to field of view and depth of field. In addition it contains two geometries (triangle of fov and trapezoid of dof)
     */
    @Version("1")
    @Get("/calc")
    @Produces(MediaType.APPLICATION_JSON)
    @Header(name=CACHE_CONTROL,value="no-cache")
    public HttpResponse<?> calcFoV(final Double latitude1, final Double longitude1, final Double latitude2, final Double longitude2, final Integer focal_length, final Double aperture, final String sensor_format, final String orientation, final HttpRequest request) {
        final double lat1         = null == latitude1 ? 0 : latitude1;
        final double lon1         = null == longitude1 ? 0 : longitude1;
        final double lat2         = null == latitude2 ? 0 : latitude2;
        final double lon2         = null == longitude2 ? 0 : longitude2;
        final int    focalLength  = null == focal_length ? 50 : focal_length;
        final double apert        = null == aperture ? 2.8 : aperture;
        SensorFormat sensorFormat = SensorFormat.fromText(sensor_format);
        Orientation  orient       = Orientation.fromText(orientation);

        if (SensorFormat.NOT_FOUND == sensorFormat) { sensorFormat = SensorFormat.FULL_FORMAT; }
        if (Orientation.NOT_FOUND  == orient)       { orient       = Orientation.LANDSCAPE; }

        final GeoLocation cameraLocation  = new GeoLocation(lat1, lon1);
        final GeoLocation subjectLocation = new GeoLocation(lat2, lon2);
        final Data data = Helper.calc(cameraLocation, subjectLocation, focalLength, apert, sensorFormat, orient);

        HttpResponse response = HttpResponse.ok(data.toString()).contentType(MediaType.APPLICATION_JSON).status(HttpStatus.OK);
        return response;
    }
}