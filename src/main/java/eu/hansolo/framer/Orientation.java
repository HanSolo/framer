package eu.hansolo.framer;

import static eu.hansolo.toolbox.Constants.*;


public enum Orientation {
    LANDSCAPE("Landscape", "landscape"),
    PORTRAIT("Portrait", "portrait"),
    NOT_FOUND("", "");

    public final String uiString;
    public final String apiString;


    // ******************** Constructors **************************************
    Orientation(final String uiString, final String apiString) {
        this.uiString  = uiString;
        this.apiString = apiString;
    }


    // ******************** Methods *******************************************
    public static final Orientation fromText(final String text) {
        switch(text) {
            case "lanscape", "LANDSCAPE", "Landscape" -> { return Orientation.LANDSCAPE; }
            case "portrait", "PORTRAIT", "Portrait"   -> { return Orientation.PORTRAIT; }
            default                                   -> { return Orientation.NOT_FOUND; }
        }
    }

    @Override public String toString() {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("ui_string").append(QUOTES).append(COLON).append(QUOTES).append(uiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("api_string").append(QUOTES).append(COLON).append(QUOTES).append(apiString).append(QUOTES)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }
}
