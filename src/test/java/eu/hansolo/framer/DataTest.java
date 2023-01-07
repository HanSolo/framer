package eu.hansolo.framer;

import org.junit.jupiter.api.Test;

import java.util.Locale;


public class DataTest {
    private static final GeoLocation HOME       = new GeoLocation(51.9120268350476, 7.6338728239553495, 67);
    private static final GeoLocation LOCATION_2 = new GeoLocation(51.911510620555674, 7.632810650837488, 65);

    @Test
    void dataTest() {
        Data data = Helper.calc(HOME, LOCATION_2,400, 4.5, SensorFormat.FULL_FORMAT, Orientation.LANDSCAPE);

        System.out.println(data);
    }

}
