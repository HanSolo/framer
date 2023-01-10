package eu.hansolo.framer;

import static eu.hansolo.toolbox.Constants.*;


public enum TeleConverter {
    TC_1_4("tc 1.4", "tc_1_4", 1.4),
    TC_2_0("tc 2.0", "tc_2_0", 2.0),
    NOT_FOUND("", "", 1.0);

    public final String uiString;
    public final String apiString;
    public final double factor;


    // ******************** Constructors **************************************
    TeleConverter(final String uiString, final String apiString, final double factor) {
        this.uiString  = uiString;
        this.apiString = apiString;
        this.factor    = factor;
    }


    // ******************** Methods *******************************************
    public static final TeleConverter fromText(final String text) {
        switch(text) {
            case "tc_1_4", "tc1.4", "1.4x" -> { return TC_1_4; }
            case "tc_2_0", "tc2.0", "2.0x" -> { return TC_2_0; }
            default                        -> { return TeleConverter.NOT_FOUND; }
        }
    }

    @Override public String toString() {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("ui_string").append(QUOTES).append(COLON).append(QUOTES).append(uiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("api_string").append(QUOTES).append(COLON).append(QUOTES).append(apiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("factor").append(QUOTES).append(COLON).append(factor)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }
}
