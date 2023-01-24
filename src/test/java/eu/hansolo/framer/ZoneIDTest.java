package eu.hansolo.framer;

import org.junit.jupiter.api.Test;


public class ZoneIDTest {
    @Test
    void fromTextTest() {
        final String europeBerlin = "Europe/Berlin";
        ZoneID result1 = ZoneID.fromText(europeBerlin);
        assert ZoneID.EUROPE_BERLIN == result1;

        final String europeBerlinApiString = "europe_berlin";
        ZoneID result2 = ZoneID.fromText(europeBerlinApiString);
        assert ZoneID.EUROPE_BERLIN == result2;
    }
}
