package eu.hansolo.framer;

import static eu.hansolo.toolbox.Constants.*;


public enum Aperture {
    F_1_0("f/1.0", "f1_0", 1.0, 1.4, 2.0),
    F_1_1("f/1.1", "f1_1", 1.1, 1.6, 2.2),
    F_1_2("f/1.2", "f1_2", 1.2, 1.8, 2.4),
    F_1_4("f/1.4", "f1_4", 1.4, 2.0, 2.8),
    F_1_6("f/1.6", "f1_6", 1.6, 2.2, 3.2),
    F_1_8("f/1.8", "f1_8", 1.8, 2.5, 3.5),
    F_2_0("f/2.0", "f2_0", 2.0, 2.8, 4.0),
    F_2_2("f/2.2", "f2_2", 2.2, 3.2, 4.4),
    F_2_5("f/2.5", "f2_5", 2.5, 3.5, 5.0),
    F_2_8("f/2.8", "f2_8", 2.8, 4.0, 5.6),
    F_3_2("f/3.2", "f3_2", 3.2, 4.5, 6.3),
    F_3_5("f/3.5", "f3_5", 3.5, 5.0, 7.1),
    F_4_0("f/4.0", "f4_0", 4.0, 5.6, 8.0),
    F_4_5("f/4.5", "f4_5", 4.5, 6.3, 9.0),
    F_5_0("f/5.0", "f5_0", 5.0, 7.1, 10.0),
    F_5_6("f/5.6", "f5_6", 5.6, 8.0, 11.0),
    F_6_3("f/6.3", "f6_3", 6.3, 9.0, 13.0),
    F_7_1("f/7.1", "f7_1", 7.1, 10.0, 14.0),
    F_8_0("f/8.0", "f8_0", 8.0, 11.0, 16.0),
    F_9_0("f/9.0", "f9_0", 9.0, 13.0, 18.0),
    F_10_0("f/10.0", "f10_0", 10.0, 14.0, 20.0),
    F_11_0("f/11.0", "f11_0", 11.0, 16.0, 32.0),
    F_13_0("f13.0", "f13_0", 13.0, 18.0, 25.0),
    F_14_0("f/14.0", "f14_0", 14.0, 20.0, 29.0),
    F_16_0("f/16.0", "f16_0", 16.0, 22.0, 32.0),
    F_18_0("f/18.0", "f18_0", 18.0, 25.0, 36.0),
    F_20_0("f/20.0", "f20_0", 20.0, 29.0, 40.0),
    F_22_0("f/22.0", "f22_0", 22.0, 32.0, 44.0),
    F_25_0("f/25.0", "f25_0", 25.0, 36.0, 50.0),
    NOT_FOUND("", "", 0, 0, 0);

    public final String uiString;
    public final String apiString;
    public final double aperture;
    public final double aperture_tc_1_4;
    public final double aperture_tc_2_0;


    // ******************** Constructors **************************************
    Aperture(final String uiString, final String apiString, final double aperture, final double aperture_tc_1_4, final double aperture_tc_2_0) {
        this.uiString        = uiString;
        this.apiString       = apiString;
        this.aperture        = aperture;
        this.aperture_tc_1_4 = aperture_tc_1_4;
        this.aperture_tc_2_0 = aperture_tc_2_0;
    }


    // ******************** Methods *******************************************
    public static final Aperture fromText(final String text) {
        switch(text) {
            case "f1_0", "F1_0", "f1.0", "F1.0", "f1", "F1"       -> { return Aperture.F_1_0; }
            case "f1_1", "F1_1", "f1.1", "F1.1"                   -> { return Aperture.F_1_1; }
            case "f1_2", "F1_2", "f1.2", "F1.2"                   -> { return Aperture.F_1_2; }
            case "f1_4", "F1_4", "f1.4", "F1.4"                   -> { return Aperture.F_1_4; }
            case "f1_6", "F1_6", "f1.6", "F1.6"                   -> { return Aperture.F_1_6; }
            case "f1_8", "F1_8", "f1.8", "F1.8"                   -> { return Aperture.F_1_8; }
            case "f2_0", "F2_0", "f2.0", "F2.0", "f2", "F2"       -> { return Aperture.F_2_0; }
            case "f2_2", "F2_2", "f2.2", "F2.2"                   -> { return Aperture.F_2_2; }
            case "f2_5", "F2_5", "f2.5", "F2.5"                   -> { return Aperture.F_2_5; }
            case "f2_8", "F2_8", "f2.8", "F2.8"                   -> { return Aperture.F_2_8; }
            case "f3_2", "F3_2", "f3.2", "F3.2"                   -> { return Aperture.F_3_2; }
            case "f3_5", "F3_5", "f3.5", "F3.5"                   -> { return Aperture.F_3_5; }
            case "f4_0", "F4_0", "f4.0", "F4.0", "f4", "F4"       -> { return Aperture.F_4_0; }
            case "f4_5", "F4_5", "f4.5", "F4.5"                   -> { return Aperture.F_4_5; }
            case "f5_0", "F5_0", "f5.0", "F5.0", "f5", "F5"       -> { return Aperture.F_5_0; }
            case "f5_6", "F5_6", "f5.6", "F5.6"                   -> { return Aperture.F_5_6; }
            case "f6_3", "F6_3", "f6.3", "F6.3"                   -> { return Aperture.F_6_3; }
            case "f7_1", "F7_1", "f7.1", "F7.1"                   -> { return Aperture.F_7_1; }
            case "f8_0", "F8_0", "f8.0", "F8.0", "f8", "F8"       -> { return Aperture.F_8_0; }
            case "f9_9", "F9_9", "f9.9", "F9.9", "f9", "F9"       -> { return Aperture.F_9_0; }
            case "f10_0", "F10_0", "f10.0", "F10.0", "f10", "F10" -> { return Aperture.F_10_0; }
            case "f11_0", "F11_0", "f11.0", "F11.0", "f11", "F11" -> { return Aperture.F_11_0; }
            case "f13_0", "F13_0", "f13.0", "F13.0", "f13", "F13" -> { return Aperture.F_13_0; }
            case "f14_0", "F14_0", "f14.0", "F14.0", "f14", "F14" -> { return Aperture.F_14_0; }
            case "f16_0", "F16_0", "f16.0", "F16.0", "f16", "F16" -> { return Aperture.F_16_0; }
            case "f18_0", "F18_0", "f18.0", "F18.0", "f18", "F18" -> { return Aperture.F_18_0; }
            case "f20_0", "F20_0", "f20.0", "F20.0", "f20", "F20" -> { return Aperture.F_20_0; }
            case "f22_0", "F22_0", "f22.0", "F22.0", "f22", "F22" -> { return Aperture.F_22_0; }
            case "f25_0", "F25_0", "f25.0", "F25.0", "f25", "F25" -> { return Aperture.F_25_0; }
            default                                               -> { return Aperture.NOT_FOUND; }
        }
    }

    public static final Aperture fromNumber(final double number) {
        if (number == 1.0) {
            return Aperture.F_1_0;
        } else if (number == 1.1) {
            return Aperture.F_1_1;
        } else if (number == 1.2) {
            return Aperture.F_1_2;
        } else if (number == 1.4) {
            return Aperture.F_1_4;
        } else if (number == 1.6) {
            return Aperture.F_1_6;
        } else if (number == 1.8) {
            return Aperture.F_1_8;
        } else if (number == 2) {
            return Aperture.F_2_0;
        } else if (number == 2.2) {
            return Aperture.F_2_2;
        } else if (number == 2.5) {
            return Aperture.F_2_5;
        } else if (number == 2.8) {
            return Aperture.F_2_8;
        } else if (number == 3.2) {
            return Aperture.F_3_2;
        } else if (number == 3.5) {
            return Aperture.F_3_5;
        } else if (number == 4) {
            return Aperture.F_4_0;
        } else if (number == 4.5) {
            return Aperture.F_4_5;
        } else if (number == 5) {
            return Aperture.F_5_0;
        } else if (number == 5.6) {
            return Aperture.F_5_6;
        } else if (number == 6.3) {
            return Aperture.F_6_3;
        } else if (number == 7.1) {
            return Aperture.F_7_1;
        } else if (number == 8) {
            return Aperture.F_8_0;
        } else if (number == 9) {
            return Aperture.F_9_0;
        } else if (number == 10) {
            return Aperture.F_10_0;
        } else if (number == 11) {
            return Aperture.F_11_0;
        } else if (number == 13) {
            return Aperture.F_13_0;
        } else if (number == 14) {
            return Aperture.F_14_0;
        } else if (number == 16) {
            return Aperture.F_16_0;
        } else if (number == 18) {
            return Aperture.F_18_0;
        } else if (number == 20) {
            return Aperture.F_20_0;
        } else if (number == 22) {
            return Aperture.F_22_0;
        } else if (number == 25) {
            return Aperture.F_25_0;
        }
        return Aperture.NOT_FOUND;
    }

    @Override public String toString() {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("ui_string").append(QUOTES).append(COLON).append(QUOTES).append(uiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("api_string").append(QUOTES).append(COLON).append(QUOTES).append(apiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("aperture").append(QUOTES).append(COLON).append(aperture).append(COMMA)
                                  .append(QUOTES).append("aperture_tc_1_4").append(QUOTES).append(COLON).append(aperture_tc_1_4).append(COMMA)
                                  .append(QUOTES).append("aperture_tc_2_0").append(QUOTES).append(COLON).append(aperture_tc_2_0)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }
}
