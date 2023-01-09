package eu.hansolo.framer;

import org.junit.jupiter.api.Test;


public class LensTest {
    @Test
    void lensTest() {
        try {
            Lens lens1 = new Lens("Nikkor AFS 70-200mm f2.8 FL VR", 0, 200, 2.8, 32);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("minFocalLength cannot be smaller than " + Constants.MIN_FOCAL_LENGTH + "mm");
        }

        try {
            Lens lens2 = new Lens("Nikkor Z 400mm f4.5", 3000, 4.5);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("focalLength cannot be greater than " + Constants.MAX_FOCAL_LENGTH + "mm");
        }
    }
}
