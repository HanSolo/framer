package eu.hansolo.framer;


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
}
