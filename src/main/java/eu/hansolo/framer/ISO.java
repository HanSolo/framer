package eu.hansolo.framer;

import static eu.hansolo.toolbox.Constants.COLON;
import static eu.hansolo.toolbox.Constants.COMMA;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_CLOSE;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_OPEN;
import static eu.hansolo.toolbox.Constants.QUOTES;


public enum ISO {
    ISO_25("ISO 25", "iso_25", 25),
    ISO_50("ISO 50", "iso_50", 50),
    ISO_64("ISO 64", "iso_64", 64),
    ISO_80("ISO 80", "iso_80", 80),
    ISO_100("ISO 100", "iso_100", 100),
    ISO_125("ISO 125", "iso_125", 125),
    ISO_160("ISO 160", "iso_160", 160),
    ISO_200("ISO 200", "iso_200", 200),
    ISO_250("ISO 250", "iso_250", 250),
    ISO_320("ISO 320", "iso_320", 320),
    ISO_400("ISO 400", "iso_400", 400),
    ISO_500("ISO 500", "iso_500", 500),
    ISO_640("ISO 640", "iso_640", 640),
    ISO_800("ISO 800", "iso_800", 800),
    ISO_1000("ISO 1000", "iso_1000", 1000),
    ISO_1250("ISO 1250", "iso_1250", 1250),
    ISO_1600("ISO 1600", "iso_1600", 1600),
    ISO_2000("ISO 2000", "iso_2000", 2000),
    ISO_2500("ISO 2500", "iso_2500", 2500),
    ISO_3200("ISO 3200", "iso_3200", 3200),
    ISO_4000("ISO 4000", "iso_4000", 4000),
    ISO_5000("ISO 5000", "iso_5000", 5000),
    ISO_6400("ISO 6400", "iso_6400", 6400),
    ISO_8000("ISO 8000", "iso_8000", 8000),
    ISO_10000("ISO 10000", "iso_10000", 10000),
    ISO_12800("ISO 12800", "iso_12800", 12800),
    ISO_16000("ISO 16000", "iso_16000", 16000),
    ISO_20000("ISO 20000", "iso_20000", 20000),
    ISO_25600("ISO 25600", "iso_25600", 25600),
    ISO_51200("ISO 51200", "iso_51200", 51200),
    ISO_102400("ISO 102400", "iso_102400", 102400),
    NOT_FOUND("", "", 0);


    public final String uiString;
    public final String apiString;
    public final int    value;


    // ******************** Constructors **************************************
    ISO(final String uiString, final String apiString, final int value) {
        this.uiString  = uiString;
        this.apiString = apiString;
        this.value     = value;
    }


    // ******************** Methods *******************************************
    public static final ISO fromText(final String text) {
        switch(text) {
            case "iso_25"     -> { return ISO_25; }
            case "iso_50"     -> { return ISO_50; }
            case "iso_64"     -> { return ISO_64; }
            case "iso_80"     -> { return ISO_80; }
            case "iso_100"    -> { return ISO_100; }
            case "iso_125"    -> { return ISO_125; }
            case "iso_160"    -> { return ISO_160; }
            case "iso_200"    -> { return ISO_200; }
            case "iso_250"    -> { return ISO_250; }
            case "iso_320"    -> { return ISO_320; }
            case "iso_400"    -> { return ISO_400; }
            case "iso_500"    -> { return ISO_500; }
            case "iso_640"    -> { return ISO_640; }
            case "iso_800"    -> { return ISO_800; }
            case "iso_1000"   -> { return ISO_1000; }
            case "iso_1250"   -> { return ISO_1250; }
            case "iso_1600"   -> { return ISO_1600; }
            case "iso_2000"   -> { return ISO_2000; }
            case "iso_2500"   -> { return ISO_2500; }
            case "iso_3200"   -> { return ISO_3200; }
            case "iso_4000"   -> { return ISO_4000; }
            case "iso_5000"   -> { return ISO_5000; }
            case "iso_6400"   -> { return ISO_6400; }
            case "iso_8000"   -> { return ISO_8000; }
            case "iso_10000"  -> { return ISO_10000; }
            case "iso_12800"  -> { return ISO_12800; }
            case "iso_16000"  -> { return ISO_16000; }
            case "iso_20000"  -> { return ISO_20000; }
            case "iso_25600"  -> { return ISO_25600; }
            case "iso_51200"  -> { return ISO_51200; }
            case "iso_102400" -> { return ISO_102400; }
            default           -> { return ISO.NOT_FOUND; }
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
