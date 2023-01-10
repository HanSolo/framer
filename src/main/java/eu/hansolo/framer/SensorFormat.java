package eu.hansolo.framer;

import static eu.hansolo.toolbox.Constants.*;


public enum SensorFormat {
    MEDIUM_FORMAT("Medium Format", "medium_format", 53.7, 40.2, 0.64),
    FULL_FORMAT("Full Format", "full_format", 36, 23.9, 1.0),
    APS_H("APS-H", "aps_h", 27.9, 18.6, 1.29),
    APS_C("APS-C", "aps_c", 23.6, 15.8, 1.53),
    APS_C_CANON("APS-C Canon", "aps_c_canon", 22.2, 14.8, 1.62),
    MICRO_FOUR_THIRDS("Micro 4/3", "micro_4_3", 17.3, 13.0, 2.0),
    ONE("1\\\"", "one", 12.8, 9.6, 2.7),
    ONE_DOT_FIVE("1.5\\\"", "one_dot_five", 10.67, 8, 3.244),
    TWO_THIRDS("2/3\\\"", "two_thirds", 8.8, 6.6, 4.5),
    ONE_ONE_DOT_SEVEN("1/1.7\\\"", "one_one_dot_seven", 7.6, 5.7, 4.55),
    ONE_TWO_DOT_THREE("1/2.3\\\"", "one_two_dot_three", 6.17, 4.55, 5.64),
    ONE_TWO_DOT_FIVE("1/2.5\\\"", "one_two_dot_five", 5.76, 4.29, 6.0),
    ONE_THREE_DOT_TWO("1/3.2\\\"", "one_three_dot_two", 4.54, 3.42, 0),
    NOT_FOUND("", "", 0, 0, 0);

    public final String uiString;
    public final String apiString;
    public final double width;
    public final double height;
    public final double cropFactor;


    // ******************** Constructors **************************************
    SensorFormat(final String uiString, final String apiString, final double width, final double height, final double cropFactor) {
        this.uiString   = uiString;
        this.apiString  = apiString;
        this.width      = width;
        this.height     = height;
        this.cropFactor = cropFactor;
    }


    // ******************** Methods *******************************************
    public static final SensorFormat fromText(final String text) {
        switch(text) {
            case "medium_format", "MEDIUM_FORMAT", "medium-format", "MEDIUM-FORMAT", "Medium-Format", "medium format", "Medium Format" -> { return SensorFormat.MEDIUM_FORMAT; }
            case "full_format", "FULL_FORMAT", "full-format", "FULL-FORMAT", "Full-Format", "full format", "Full Format"               -> { return SensorFormat.FULL_FORMAT ;}
            case "aps_h", "APS_H", "aps-h", "APS-H", "aps h", "APS H"                                                                  -> { return SensorFormat.APS_H; }
            case "aps_c", "APS_C", "aps-c", "APS-C", "aps c", "APS C"                                                                  -> { return SensorFormat.APS_C; }
            case "aps_c_canon", "APS_C_CANON", "aps-c-canon", "APS-C-CANON", "aps c canon", "APS C CANON"                              -> { return SensorFormat.APS_C_CANON; }
            case "micro_4_3", "MICRO_4_3", "micro-4-3", "MICRO-4-3", "micro 4 3", "MICRO 4 3"                                          -> { return SensorFormat.MICRO_FOUR_THIRDS; }
            case "one", "ONE"                                                                                                          -> { return SensorFormat.ONE_THREE_DOT_TWO; }
            case "one_dot_five", "ONE_DOT_FIVE", "one-dot-five", "ONE-DOT-FIVE"                                                        -> { return SensorFormat.ONE_DOT_FIVE; }
            case "two_thirds", "TWO_THIRDS", "two-thirds", "TWO-THIRDS"                                                                -> { return SensorFormat.TWO_THIRDS; }
            case "one_one_dot_seven", "ONE_ONE_DOT_SEVEN", "one-one-dot-seven", "ONE-ONE-DOT-SEVEN"                                    -> { return SensorFormat.ONE_ONE_DOT_SEVEN; }
            case "one_two_dot_three", "ONE_TWO_DOT_THREE", "one-two-dot-three", "ONE-TWO-DOT-THREE"                                    -> { return SensorFormat.ONE_TWO_DOT_THREE; }
            case "one_two_dot_five", "ONE_TWO_DOT_FIVE", "one-two-dot-five", "ONE-TWO-DOT-FIVE"                                        -> { return SensorFormat.ONE_TWO_DOT_FIVE; }
            case "one_three_dot_two", "ONE_THREE_DOT_TWO", "one-three-dot-two", "ONE-THREE-DOT-TWO"                                    -> { return SensorFormat.ONE_THREE_DOT_TWO; }
            default                                                                                                                    -> { return SensorFormat.NOT_FOUND; }
        }
    }

    @Override public String toString() {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("ui_string").append(QUOTES).append(COLON).append(QUOTES).append(uiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("api_string").append(QUOTES).append(COLON).append(QUOTES).append(apiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("width").append(QUOTES).append(COLON).append(width).append(COMMA)
                                  .append(QUOTES).append("height").append(QUOTES).append(COLON).append(height).append(COMMA)
                                  .append(QUOTES).append("crop_factor").append(QUOTES).append(COLON).append(cropFactor)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }
}
