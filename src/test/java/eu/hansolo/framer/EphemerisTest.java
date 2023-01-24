package eu.hansolo.framer;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;


public class EphemerisTest {
    private static final GeoLocation HOME               = new GeoLocation(51.9120268350476, 7.6338728239553495, 67);
    private static final GeoLocation HELSINKI_CATHEDRAL = new GeoLocation(60.17068771835006, 24.95220866505181, 0);

    @Test
    void testSunriseSunset() {
        try {
            final Ephemeris ephemeris = new Ephemeris(2023, 1, 24, HOME.getLatitude(), HOME.getLongitude());
            ephemeris.calcEphemeris(ZoneId.systemDefault());
            ephemeris.calcSunAndMoon();
            assert ephemeris.getSunrise().getHour()   == 8;
            assert ephemeris.getSunrise().getMinute() == 20;
            assert ephemeris.getSunset().getHour()    == 17;
            assert ephemeris.getSunset().getMinute()  == 2;

            ephemeris.setLocation(HELSINKI_CATHEDRAL.getLatitude(), HELSINKI_CATHEDRAL.getLongitude());
            ephemeris.calcEphemeris(ZoneId.systemDefault());
            ephemeris.calcSunAndMoon();
            assert ephemeris.getSunrise().getHour()   == 7;
            assert ephemeris.getSunrise().getMinute() == 53;
            assert ephemeris.getSunset().getHour()    == 15;
            assert ephemeris.getSunset().getMinute()  == 11;
        } catch (Exception e) {

        }
    }
}
