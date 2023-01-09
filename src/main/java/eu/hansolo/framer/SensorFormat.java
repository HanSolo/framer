package eu.hansolo.framer;


public enum SensorFormat {
    MEDIUM_FORMAT("Medium Format", "medium_format", 53.7, 40.2, 0.64),
    FULL_FORMAT("Full Format", "full_format", 36, 23.9, 1.0),
    APS_H("APS-H", "aps_h", 27.9, 18.6, 1.29),
    APS_C("APS-C", "aps_c", 23.6, 15.8, 1.52),
    APS_C_CANON("APS-C Canon", "aps_c_canon", 22.2, 14.8, 1.6),
    MICRO_FOUR_THIRDS("Micro 4/3", "micro_4_3", 17.3, 13.0, 2.0),
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
            default                                                                                                                    -> { return SensorFormat.NOT_FOUND; }
        }
    }
}
