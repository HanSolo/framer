package eu.hansolo.framer;

import org.junit.jupiter.api.Test;


public class FovDataTest {
    private static final GeoLocation HOME       = new GeoLocation(51.9120268350476, 7.6338728239553495, 67);
    private static final GeoLocation LOCATION_2 = new GeoLocation(51.911510620555674, 7.632810650837488, 65);

    @Test
    void fovDataTest() {
        //System.out.println(Helper.calc(HOME, LOCATION_2, 400, 4.5, SensorFormat.FULL_FORMAT, Orientation.LANDSCAPE));
        try {
            FovData wrongFovData = Helper.calc(HOME, LOCATION_2, 3000, 4.5, SensorFormat.FULL_FORMAT, Orientation.LANDSCAPE);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Error, focal length must be between 8mm and 2400mm");
        }

        GeoLocation location1  = new GeoLocation(51.91169178378304, 7.633822331799516);
        GeoLocation location2  = new GeoLocation(51.91152234041318, 7.6328298445623);
        double      bearing    = Helper.calcBearingInDegree(location1, location2);

        FovData  fovData            = Helper.calc(location1, location2, 400, 4.5, SensorFormat.FULL_FORMAT, Orientation.LANDSCAPE);
        Triangle fovTriangle        = Helper.getFoVTriangle(fovData);
        Triangle rotatedFovTriangle = Helper.rotateTriangleAroundRotationCenter(fovTriangle, location1, 360.0 - bearing);
        System.out.println(rotatedFovTriangle);
    }
}
