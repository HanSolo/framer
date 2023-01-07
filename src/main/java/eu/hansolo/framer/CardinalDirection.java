package eu.hansolo.framer;

public enum CardinalDirection {
    N("North", "n",348.75, 11.25),
    NNE("North North-East", "nne", 11.25, 33.75),
    NE("North-East", "ne", 33.75, 56.25),
    ENE("East North-East", "ene", 56.25, 78.75),
    E("East", "e", 78.75, 101.25),
    ESE("East South-East", "ese", 101.25, 123.75),
    SE("South-East", "se",123.75, 146.25),
    SSE("South South-East", "sse", 146.25, 168.75),
    S("South", "s", 168.75, 191.25),
    SSW("South South-West", "ssw", 191.25, 213.75),
    SW("South-West", "sw", 213.75, 236.25),
    WSW("West South-West", "wsw", 236.25, 258.75),
    W("West", "w", 258.75, 281.25),
    WNW("West North-West", "wnw", 281.25, 303.75),
    NW("North-West", "nw", 303.75, 326.25),
    NNW("North North-West", "nnw", 326.25, 348.75),
    NOT_FOUND("", "", 0, 0);

    public final String uiString;
    public final String apiString;
    public final double from;
    public final double to;


    // ******************** Constructors **************************************
    CardinalDirection(final String uiString, final String apiString, final double from, final double to) {
        this.uiString  = uiString;
        this.apiString = apiString;
        this.from      = from;
        this.to        = to;
    }


    // ******************** Methods *******************************************
    public static final CardinalDirection fromText(final String text) {
        switch(text) {
            case "n", "N"     -> { return CardinalDirection.N; }
            case "nne", "NNE" -> { return CardinalDirection.NNE; }
            case "ne", "NE"   -> { return CardinalDirection.NE; }
            case "ene", "ENE" -> { return CardinalDirection.ENE; }
            case "e", "E"     -> { return CardinalDirection.E; }
            case "ese", "ESE" -> { return CardinalDirection.ESE; }
            case "se", "SE"   -> { return CardinalDirection.SE; }
            case "sse", "SSE" -> { return CardinalDirection.SSE; }
            case "s", "S"     -> { return CardinalDirection.S; }
            case "ssw", "SSW" -> { return CardinalDirection.SSW; }
            case "sw", "SW"   -> { return CardinalDirection.SW; }
            case "wsw", "WSW" -> { return CardinalDirection.WSW; }
            case "w", "W"     -> { return CardinalDirection.W; }
            case "wnw", "WNW" -> { return CardinalDirection.WNW; }
            case "nw", "NW"   -> { return CardinalDirection.NW; }
            case "nnw", "NNW" -> { return CardinalDirection.NNW; }
            default           -> { return CardinalDirection.NOT_FOUND; }
        }
    }
}

