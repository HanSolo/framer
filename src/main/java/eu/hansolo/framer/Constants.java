package eu.hansolo.framer;

public class Constants {
    private Constants() {}

    public static final int    MIN_FOCAL_LENGTH = 8;
    public static final int    MAX_FOCAL_LENGTH = 2400;
    public static final double MIN_APERTURE     = 0.7;
    public static final double MAX_APERTURE     = 99.0;
    public static final double MIN_DISTANCE     = 0.01;
    public static final double MAX_DISTANCE     = 9999.0;

    // Equatorial radius of WGS84 ellipsoid [m]
    public static final double WGS84_a = 6_378_137.0;

    // Polar radius of WGS84 ellipsoid [m]
    public static final double WGS84_b = 6_356_752.3142;

    // Camera height above ground
    public static final double CAMERA_HEIGHT = 1.6;
}
