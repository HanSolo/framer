package eu.hansolo.framer;

import org.junit.jupiter.api.Test;


public class HelperTest {
    private static final GeoLocation HOME       = new GeoLocation(51.9120268350476, 7.6338728239553495, 67);
    private static final GeoLocation LOCATION_2 = new GeoLocation(51.911510620555674, 7.632810650837488, 65);
    private static final GeoLocation NEW_YORK   = new GeoLocation(40.741895, -73.989308, 0);

    @Test
    void testGeoLocation() {
        GeoLocation location = HOME.getCopy();

        location.setLatitude(-120);
        assert location.getLatitude() == -60;

        location.setLatitude(120);
        assert location.getLatitude() == 60;

        location.setLongitude(-200);
        assert location.getLongitude() == 160;

        location.setLongitude(200);
        assert location.getLongitude() == -160;

        System.out.println(Helper.calcDistanceInMeters(HOME, NEW_YORK) / 1000);
        System.out.println(Helper.calcDistanceInMetersMorePrecise(HOME, NEW_YORK) / 1000);
    }

    @Test
    void testRound() {
        double aperture    = 1.3999999999999;
        String roundedText = new StringBuilder().append(Helper.round(aperture, 1)).toString();
        assert roundedText.equals("1.4");
    }

    @Test
    void testCalculateEV() {
        EV ev = Helper.calcExposureValue(Aperture.F_2_8, ShutterSpeed.SP_1_500, ISO.ISO_200);
        assert ev == EV.EV_11;

        ev = Helper.calcExposureValue(Aperture.F_8_0, ShutterSpeed.SP_1_500, ISO.ISO_200);
        assert ev == EV.EV_14;
    }
}
