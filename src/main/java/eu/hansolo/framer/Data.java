package eu.hansolo.framer;

import java.util.Locale;

import static eu.hansolo.toolbox.Constants.*;


public class Data {
    public final GeoLocation  cameraLocation;
    public final GeoLocation  subjectLocation;
    public final double       focalLength;
    public final double       aperture;
    public final double       distance;
    public final SensorFormat sensorFormat;
    public final Orientation  orientation;
    public final boolean      infinite;
    public final double       hyperFocal;
    public final double       nearLimit;
    public final double       farLimit;
    public final double       frontPercent;
    public final double       behindPercent;
    public final double       total;
    public final double       diagonalAngle;
    public final double       diagonalLength;
    public final double       fovWidth;
    public final double       fovWidthAngle;
    public final double       fovHeight;
    public final double       fovHeightAngle;
    public final double       radius;
    public final double       angleBetweenCameraAndMotif;
    public final double       dofInFront;
    public final double       dofBehind;


    public Data(final GeoLocation cameraLocation, final GeoLocation subjectLocation,
                final double focalLength, final double aperture,
                final SensorFormat sensorFormat,
                final Orientation orientation,
                final boolean infinite, final double hyperFocal, final double nearLimit, final double farLimit,
                final double frontPercent, final double behindPercent, final double total,
                final double diagonalAngle, final double diagonalLength,
                final double fovWidth, final double fovWidthAngle,
                final double fovHeight, final double fovHeightAngle,
                final double radius) {
        this.cameraLocation             = cameraLocation;
        this.subjectLocation            = subjectLocation;
        this.focalLength                = focalLength;
        this.aperture                   = aperture;
        this.distance                   = cameraLocation.getDistanceTo(subjectLocation);
        this.sensorFormat               = sensorFormat;
        this.orientation                = orientation;
        this.infinite                   = infinite;
        this.hyperFocal                 = hyperFocal;
        this.nearLimit                  = nearLimit;
        this.farLimit                   = infinite ? 10000 : farLimit;
        this.frontPercent               = frontPercent;
        this.behindPercent              = behindPercent;
        this.total                      = infinite ? 10000 : total;
        this.diagonalAngle              = diagonalAngle;
        this.diagonalLength             = diagonalLength;
        this.fovWidth                   = fovWidth;
        this.fovWidthAngle              = fovWidthAngle;
        this.fovHeight                  = fovHeight;
        this.fovHeightAngle             = fovHeightAngle;
        this.radius                     = radius;
        this.angleBetweenCameraAndMotif = Math.toRadians(Helper.calcBearingInDegree(cameraLocation, subjectLocation));
        this.dofInFront                 = distance - nearLimit;
        this.dofBehind                  = infinite ? 10000 : farLimit - distance;
    }


    @Override public String toString() {
        Triangle  fovTriangle  = Helper.getFoVTriangle(Data.this);
        Trapezoid dofTrapezoid = Helper.getDofTrapezoid(Data.this);

        final String res = new StringBuilder().append(CURLY_BRACKET_OPEN)
                                              .append(QUOTES).append("camera_latitude").append(QUOTES).append(COLON).append(cameraLocation.getLatitude()).append(COMMA)
                                              .append(QUOTES).append("camera_longitude").append(QUOTES).append(COLON).append(cameraLocation.getLongitude()).append(COMMA)
                                              .append(QUOTES).append("subject_latitude").append(QUOTES).append(COLON).append(subjectLocation.getLatitude()).append(COMMA)
                                              .append(QUOTES).append("subject_longitude").append(QUOTES).append(COLON).append(subjectLocation.getLongitude()).append(COMMA)
                                              .append(QUOTES).append("sensor_format").append(QUOTES).append(COLON).append(QUOTES).append(sensorFormat.apiString).append(QUOTES).append(COMMA)
                                              .append(QUOTES).append("sensor_width").append(QUOTES).append(COLON).append(sensorFormat.width).append(COMMA)
                                              .append(QUOTES).append("sensor_height").append(QUOTES).append(COLON).append(sensorFormat.height).append(COMMA)
                                              .append(QUOTES).append("focal_length").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.0f", (focalLength * 1000.0))).append(COMMA)
                                              .append(QUOTES).append("aperture").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.1f", aperture)).append(COMMA)
                                              .append(QUOTES).append("orientation").append(QUOTES).append(COLON).append(QUOTES).append(orientation.apiString).append(QUOTES).append(COMMA)
                                              .append(QUOTES).append("distance_to_subject").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.2f", distance)).append(COMMA)
                                              .append(QUOTES).append("hyper_focal_distance").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.2f", hyperFocal)).append(COMMA)
                                              .append(QUOTES).append("fov_width").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.2f", fovWidth)).append(COMMA)
                                              .append(QUOTES).append("fov_height").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.2f", fovHeight)).append(COMMA)
                                              .append(QUOTES).append("fov_width_angle").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.2f", fovWidthAngle)).append(COMMA)
                                              .append(QUOTES).append("fov_height_angle").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.2f", fovHeightAngle)).append(COMMA)
                                              .append(QUOTES).append("dof_near_limit").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.2f", nearLimit)).append(COMMA)
                                              .append(QUOTES).append("dof_far_limit").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.2f", farLimit)).append(COMMA)
                                              .append(QUOTES).append("dof_total").append(QUOTES).append(COLON).append(String.format(Locale.US, "%.2f", total)).append(COMMA)
                                              .append(QUOTES).append("features").append(QUOTES).append(COLON).append(SQUARE_BRACKET_OPEN)
                                              .append(fovTriangle)
                                              .append(COMMA)
                                              .append(dofTrapezoid)
                                              .append(SQUARE_BRACKET_CLOSE)
                                              .append(CURLY_BRACKET_CLOSE)
                                              .toString();

        return res;
    }
}
