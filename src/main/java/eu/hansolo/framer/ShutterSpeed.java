package eu.hansolo.framer;

import static eu.hansolo.toolbox.Constants.COLON;
import static eu.hansolo.toolbox.Constants.COMMA;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_CLOSE;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_OPEN;
import static eu.hansolo.toolbox.Constants.QUOTES;


public enum ShutterSpeed {
    SP_1_32000("1/32000", "sp_1_32000", 1/32000.0),
    SP_1_16000("1/16000", "sp_1_16000", 1/16000.0),
    SP_1_8000("1/8000", "sp_1_8000", 1/8000.0),
    SP_1_4000("1/4000", "sp_1_4000", 1/4000.0),
    SP_1_2000("1/2000", "sp_1_2000", 1/2000.0),
    SP_1_1000("1/1000", "sp_1_1000", 1/1000.0),
    SP_1_500("1/500", "sp_1_500", 1/500.0),
    SP_1_250("1/250", "sp_1_250", 1/250.0),
    SP_1_125("1/125", "sp_1_125", 1/125.0),
    SP_1_60("1/60", "sp_1_60", 1/60.0),
    SP_1_30("1/30", "sp_1_30", 1/30.0),
    SP_1_15("1/15", "sp_1_15", 1/15.0),
    SP_1_8("1/8", "sp_1_8", 1/8.0),
    SP_1_4("1/4", "sp_1_4", 1/4.0),
    SP_1_2("1/2", "sp_1_2", 1/2.0),
    SP_1("1", "sp_1", 1.0),
    SP_2("2", "sp_2", 2.0),
    SP_4("4", "sp_4", 4.0),
    SP_8("8", "sp_8", 8.0),
    SP_15("15", "sp_15", 15.0),
    SP_30("30", "sp_30", 30.0),
    SP_60("60", "sp_60", 60.0),
    NOT_FOUND("", "", 0.0);


    public final String uiString;
    public final String apiString;
    public final double value;


    // ******************** Constructors **************************************
    ShutterSpeed(final String uiString, final String apiString, final double value) {
        this.uiString  = uiString;
        this.apiString = apiString;
        this.value     = value;
    }


    // ******************** Methods *******************************************
    public static final ShutterSpeed fromText(final String text) {
        switch(text) {
            case "sp_1_32000" -> { return SP_1_32000; }
            case "sp_1_16000" -> { return SP_1_16000; }
            case "sp_1_8000"  -> { return SP_1_8000; }
            case "sp_1_4000"  -> { return SP_1_4000; }
            case "sp_1_2000"  -> { return SP_1_2000; }
            case "sp_1_1000"  -> { return SP_1_1000; }
            case "sp_1_500"   -> { return SP_1_500; }
            case "sp_1_250"   -> { return SP_1_250; }
            case "sp_1_125"   -> { return SP_1_125; }
            case "sp_1_60"    -> { return SP_1_60; }
            case "sp_1_30"    -> { return SP_1_30; }
            case "sp_1_15"    -> { return SP_1_15; }
            case "sp_1_8"     -> { return SP_1_8; }
            case "sp_1_4"     -> { return SP_1_4; }
            case "sp_1_2"     -> { return SP_1_2; }
            case "sp_1"       -> { return SP_1; }
            case "sp_2"       -> { return SP_2; }
            case "sp_4"       -> { return SP_4; }
            case "sp_8"       -> { return SP_8; }
            case "sp_15"      -> { return SP_15; }
            case "sp_30"      -> { return SP_30; }
            case "sp_60"      -> { return SP_60; }
            default           -> { return ShutterSpeed.NOT_FOUND; }
        }
    }

    @Override public String toString() {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("ui_string").append(QUOTES).append(COLON).append(QUOTES).append(uiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("api_string").append(QUOTES).append(COLON).append(QUOTES).append(apiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("value").append(QUOTES).append(COLON).append(value)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }
}
