package eu.hansolo.framer;

import static eu.hansolo.toolbox.Constants.*;


public class FovData {
    public final GeoLocation  cameraLocation;
    public final GeoLocation  subjectLocation;
    public final double       focalLength;
    public final double       aperture;
    public final double       distance;
    public final double       bearing;
    public final SensorFormat sensorFormat;
    public final Orientation  orientation;
    public final boolean      infinite;
    public final double       hyperFocal;
    public final double       dofNearLimit;
    public final double       dofFarLimit;
    public final double       dofFrontPercent;
    public final double       dofBehindPercent;
    public final double       dofInFront;
    public final double       dofBehind;
    public final double       dofTotal;
    public final double       fovDiagonalAngle;
    public final double       fovDiagonalLength;
    public final double       fovWidth;
    public final double       fovWidthAngle;
    public final double       fovHeight;
    public final double       fovHeightAngle;
    public final double       maxSubjectHeight;
    public final double       radius;
    public final double       angleBetweenCameraAndMotif;


    // ******************** Constructors **************************************
    public FovData(final GeoLocation cameraLocation, final GeoLocation subjectLocation,
                   final double focalLength, final double aperture,
                   final SensorFormat sensorFormat,
                   final Orientation orientation,
                   final boolean infinite, final double hyperFocal, final double dofNearLimit, final double dofFarLimit,
                   final double dofFrontPercent, final double dofBehindPercent, final double dofTotal,
                   final double fovDiagonalAngle, final double fovDiagonalLength,
                   final double fovWidth, final double fovWidthAngle,
                   final double fovHeight, final double fovHeightAngle,
                   final double maxSubjectHeight, final double radius) {
        this.cameraLocation             = cameraLocation;
        this.subjectLocation            = subjectLocation;
        this.focalLength                = focalLength;
        this.aperture                   = aperture;
        this.distance                   = cameraLocation.getDistanceTo(subjectLocation);
        this.bearing                    = Helper.calcDistanceInMeters(cameraLocation, subjectLocation);
        this.sensorFormat               = sensorFormat;
        this.orientation                = orientation;
        this.infinite                   = infinite;
        this.hyperFocal                 = hyperFocal;
        this.dofNearLimit               = dofNearLimit;
        this.dofFarLimit                = infinite ? 10000 : dofFarLimit;
        this.dofFrontPercent            = dofFrontPercent;
        this.dofBehindPercent           = dofBehindPercent;
        this.dofTotal                   = infinite ? 10000 : dofTotal;
        this.fovDiagonalAngle           = fovDiagonalAngle;
        this.fovDiagonalLength          = fovDiagonalLength;
        this.fovWidth                   = fovWidth;
        this.fovWidthAngle              = fovWidthAngle;
        this.fovHeight                  = fovHeight;
        this.fovHeightAngle             = fovHeightAngle;
        this.maxSubjectHeight           = maxSubjectHeight;
        this.radius                     = radius;
        this.angleBetweenCameraAndMotif = Math.toRadians(Helper.calcBearingInDegree(cameraLocation, subjectLocation));
        this.dofInFront                 = distance - dofNearLimit;
        this.dofBehind                  = infinite ? 10000 : dofFarLimit - distance;
    }


    // ******************** Methods *******************************************
    public static String getErrorMessage(final String msg) {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("camera_latitude").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("camera_longitude").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("subject_latitude").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("subject_longitude").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("sensor_format").append(QUOTES).append(COLON).append(QUOTES).append("").append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("sensor_width").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("sensor_height").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("focal_length").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("aperture").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("orientation").append(QUOTES).append(COLON).append(QUOTES).append("").append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("distance_to_subject").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("bearing").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("hyper_focal_distance").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("fov_width").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("fov_height").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("fov_width_angle").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("fov_height_angle").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("dof_near_limit").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("dof_far_limit").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("dof_in_front").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("dof_behind").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("dof_total").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("max_subject_height").append(QUOTES).append(COLON).append(0).append(COMMA)
                                  .append(QUOTES).append("features").append(QUOTES).append(COLON).append(SQUARE_BRACKET_OPEN)
                                  .append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("type").append(QUOTES).append(COLON).append(QUOTES).append("Feature").append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("geometry").append(QUOTES).append(COLON).append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("type").append(QUOTES).append(COLON).append(QUOTES).append("Polygon").append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("coordinates").append(QUOTES).append(COLON).append(SQUARE_BRACKET_OPEN)
                                  .append(SQUARE_BRACKET_OPEN)
                                  .append(SQUARE_BRACKET_CLOSE)
                                  .append(SQUARE_BRACKET_CLOSE)
                                  .append(CURLY_BRACKET_CLOSE).append(COMMA)
                                  .append(QUOTES).append("properties").append(QUOTES).append(COLON).append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("name").append(QUOTES).append(COLON).append(QUOTES).append("fovTriangle ERROR").append(QUOTES)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .append(COMMA)
                                  .append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("type").append(QUOTES).append(COLON).append(QUOTES).append("Feature").append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("geometry").append(QUOTES).append(COLON).append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("type").append(QUOTES).append(COLON).append(QUOTES).append("Polygon").append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("coordinates").append(QUOTES).append(COLON).append(SQUARE_BRACKET_OPEN)
                                  .append(SQUARE_BRACKET_OPEN)
                                  .append(SQUARE_BRACKET_CLOSE)
                                  .append(SQUARE_BRACKET_CLOSE)
                                  .append(CURLY_BRACKET_CLOSE).append(COMMA)
                                  .append(QUOTES).append("properties").append(QUOTES).append(COLON).append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("name").append(QUOTES).append(COLON).append(QUOTES).append("dofTrapezoid ERROR").append(QUOTES)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .append(SQUARE_BRACKET_CLOSE).append(COMMA)
                                  .append(QUOTES).append("msg").append(QUOTES).append(COLON).append(QUOTES).append(msg).append(QUOTES)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }

    @Override public String toString() {
        final Triangle  fovTriangle  = Helper.getFoVTriangle(FovData.this);
        final Trapezoid dofTrapezoid = Helper.getDofTrapezoid(FovData.this);

        final String res = new StringBuilder().append(CURLY_BRACKET_OPEN)
                                              .append(QUOTES).append("camera_latitude").append(QUOTES).append(COLON).append(cameraLocation.getLatitude()).append(COMMA)
                                              .append(QUOTES).append("camera_longitude").append(QUOTES).append(COLON).append(cameraLocation.getLongitude()).append(COMMA)
                                              .append(QUOTES).append("subject_latitude").append(QUOTES).append(COLON).append(subjectLocation.getLatitude()).append(COMMA)
                                              .append(QUOTES).append("subject_longitude").append(QUOTES).append(COLON).append(subjectLocation.getLongitude()).append(COMMA)
                                              .append(QUOTES).append("sensor_format").append(QUOTES).append(COLON).append(QUOTES).append(sensorFormat.apiString).append(QUOTES).append(COMMA)
                                              .append(QUOTES).append("sensor_width").append(QUOTES).append(COLON).append(sensorFormat.width).append(COMMA)
                                              .append(QUOTES).append("sensor_height").append(QUOTES).append(COLON).append(sensorFormat.height).append(COMMA)
                                              .append(QUOTES).append("focal_length").append(QUOTES).append(COLON).append((focalLength * 1000.0)).append(COMMA)
                                              .append(QUOTES).append("aperture").append(QUOTES).append(COLON).append(Helper.round(aperture, 1)).append(COMMA)
                                              .append(QUOTES).append("orientation").append(QUOTES).append(COLON).append(QUOTES).append(orientation.apiString).append(QUOTES).append(COMMA)
                                              .append(QUOTES).append("distance_to_subject").append(QUOTES).append(COLON).append(distance).append(COMMA)
                                              .append(QUOTES).append("bearing").append(QUOTES).append(COLON).append(bearing).append(COMMA)
                                              .append(QUOTES).append("hyper_focal_distance").append(QUOTES).append(COLON).append(hyperFocal).append(COMMA)
                                              .append(QUOTES).append("fov_width").append(QUOTES).append(COLON).append(fovWidth).append(COMMA)
                                              .append(QUOTES).append("fov_height").append(QUOTES).append(COLON).append(fovHeight).append(COMMA)
                                              .append(QUOTES).append("fov_width_angle").append(QUOTES).append(COLON).append(Math.toDegrees(fovWidthAngle)).append(COMMA)
                                              .append(QUOTES).append("fov_height_angle").append(QUOTES).append(COLON).append(Math.toDegrees(fovHeightAngle)).append(COMMA)
                                              .append(QUOTES).append("dof_near_limit").append(QUOTES).append(COLON).append(dofNearLimit).append(COMMA)
                                              .append(QUOTES).append("dof_far_limit").append(QUOTES).append(COLON).append(dofFarLimit).append(COMMA)
                                              .append(QUOTES).append("dof_in_front").append(QUOTES).append(COLON).append(dofInFront).append(COMMA)
                                              .append(QUOTES).append("dof_behind").append(QUOTES).append(COLON).append(dofBehind).append(COMMA)
                                              .append(QUOTES).append("dof_total").append(QUOTES).append(COLON).append(dofTotal).append(COMMA)
                                              .append(QUOTES).append("max_subject_height").append(QUOTES).append(COLON).append(maxSubjectHeight).append(COMMA)
                                              .append(QUOTES).append("features").append(QUOTES).append(COLON).append(SQUARE_BRACKET_OPEN)
                                              .append(fovTriangle).append(COMMA)
                                              .append(dofTrapezoid)
                                              .append(SQUARE_BRACKET_CLOSE).append(COMMA)
                                              .append(QUOTES).append("msg").append(QUOTES).append(COLON).append(QUOTES).append(QUOTES)
                                              .append(CURLY_BRACKET_CLOSE)
                                              .toString();
        return res;
    }
}
