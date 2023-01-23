package eu.hansolo.framer;

import static eu.hansolo.toolbox.Constants.COLON;
import static eu.hansolo.toolbox.Constants.COMMA;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_CLOSE;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_OPEN;
import static eu.hansolo.toolbox.Constants.QUOTES;


public enum EV {
    EV_MINUS_7("EV -7", "ev_minus_7", "Deep star field or Milky Way",-7),
    EV_MINUS_6("EV -6", "ev_minus_6", "Night under starlight only or the Aurora Borealis", -6),
    EV_MINUS_5("EV -5", "ev_minus_5", "Night under crescent moon or the Aurora Borealis", -5),
    EV_MINUS_4("EV -4", "ev_minus_4", "Night under half moon, or a meteor shower (with long exposure duration", -4),
    EV_MINUS_3("EV -3", "ev_minus_3", "Night under full moon and away from city lights", -3),
    EV_MINUS_2("EV -2", "ev_minus_2", "Night snowscape under full moon and away from city lights", -2),
    EV_MINUS_1("EV -1", "ev_minus_1", "Start (sunrise) or end (sunset) of the blue hour or dim ambient lighting (indoors)", -1),
    EV_0("EV 0", "ev_0", "Dim ambient artificial light", 0),
    EV_1("EV 1", "ev_1", "Distant view of a lit skyline", 1),
    EV_2("EV 2", "ev_2", "Under lightning (with time exposure) or a total lunar eclipse", 2),
    EV_3("EV 3", "ev_3", "Fireworks (with time exposure)", 3),
    EV_4("EV 4", "ev_4", "Candle-lit close-ups, Christmas lights, floodlight buildings, fountains, or bright street lamps", 4),
    EV_5("EV 5", "ev_5", "Home interiors at night, fairs and amusement parks", 5),
    EV_6("EV 6", "ev_6", "Brightly lit home interiors at night, fairs and amusement parks", 6),
    EV_7("EV 7", "ev_7", "Bottom of a rainforest canopy, or along brightly-lit night-time streets, floodlight indoor sports areas or stadiums, and stage shows, including circuses", 7),
    EV_8("EV 8", "ev_8", "Store windows, campfires, bonfires, ice shows, floodlit indoor sports areas or stadiums, and interiors with bright fluorescent", 8),
    EV_9("EV 9", "ev_9", "Landscapes, city skylines 10 minutes after sunset, neon lights", 9),
    EV_10("EV 10", "ev_10", "Landscapes and skylines immediately after sunset, capturing a crescent moon using a long lens", 10),
    EV_11("EV 11", "ev_11", "Sunsets, subject to deep shade", 11),
    EV_12("EV 12", "ev_12", "Open shade or heavy overcast, capturing half moon using a long lens", 12),
    EV_13("EV 13", "ev_13", "Cloudy-bright light (no shadows), capturing gibbous moon using long lens", 13),
    EV_14("EV 14", "ev_14", "Weak hazy sun, rainbows (soft shadows), capturing the full moon using long lens", 14),
    EV_15("EV 15", "ev_15", "Bright or hazy sun, clear sky (distinct shadows)", 15),
    EV_16("EV 16", "ev_16", "Bright daylight on sand or snow (distinct shadows)", 16),
    EV_17("EV 17", "ev_17", "Very bright artificial lighting", 17),
    EV_18("EV 18", "ev_18", "Very bright artificial lighting", 18),
    EV_19("EV 19", "ev_19", "Very bright artificial lighting", 19),
    EV_20("EV 20+", "ev_20", "Extremely bright artificial lighting, telescopic view of the sun", 20),
    NOT_FOUND("", "", "", 0);


    public final String uiString;
    public final String apiString;
    public final String description;
    public final int    value;


    // ******************** Constructors **************************************
    EV(final String uiString, final String apiString, final String description, final int value) {
        this.uiString    = uiString;
        this.apiString   = apiString;
        this.description = description;
        this.value       = value;
    }


    // ******************** Methods *******************************************
    public static final EV fromText(final String text) {
        switch(text) {
            case "ev_minus_7" -> { return EV_MINUS_7; }
            case "ev_minus_6" -> { return EV_MINUS_6; }
            case "ev_minus_5" -> { return EV_MINUS_5; }
            case "ev_minus_4" -> { return EV_MINUS_4; }
            case "ev_minus_3" -> { return EV_MINUS_3; }
            case "ev_minus_2" -> { return EV_MINUS_2; }
            case "ev_minus_1" -> { return EV_MINUS_1; }
            case "ev_0"       -> { return EV_0; }
            case "ev_1"       -> { return EV_1; }
            case "ev_2"       -> { return EV_2; }
            case "ev_3"       -> { return EV_3; }
            case "ev_4"       -> { return EV_4; }
            case "ev_5"       -> { return EV_5; }
            case "ev_6"       -> { return EV_6; }
            case "ev_7"       -> { return EV_7; }
            case "ev_8"       -> { return EV_8; }
            case "ev_9"       -> { return EV_9; }
            case "ev_10"      -> { return EV_10; }
            case "ev_11"      -> { return EV_11; }
            case "ev_12"      -> { return EV_12; }
            case "ev_13"      -> { return EV_13; }
            case "ev_14"      -> { return EV_14; }
            case "ev_15"      -> { return EV_15; }
            case "ev_16"      -> { return EV_16; }
            case "ev_17"      -> { return EV_17; }
            case "ev_18"      -> { return EV_18; }
            case "ev_19"      -> { return EV_19; }
            case "ev_20"      -> { return EV_20; }
            default           -> { return EV.NOT_FOUND; }
        }
    }

    public static final EV fromValue(final int value) {
        if (value < -7) { return EV_MINUS_7; }
        if (value > 20) { return EV_20; }
        switch(value) {
            case  -7 -> { return EV_MINUS_7; }
            case  -6 -> { return EV_MINUS_6; }
            case  -5 -> { return EV_MINUS_5; }
            case  -4 -> { return EV_MINUS_4; }
            case  -3 -> { return EV_MINUS_3; }
            case  -2 -> { return EV_MINUS_2; }
            case  -1 -> { return EV_MINUS_1; }
            case   0 -> { return EV_0; }
            case   1 -> { return EV_1; }
            case   2 -> { return EV_2; }
            case   3 -> { return EV_3; }
            case   4 -> { return EV_4; }
            case   5 -> { return EV_5; }
            case   6 -> { return EV_6; }
            case   7 -> { return EV_7; }
            case   8 -> { return EV_8; }
            case   9 -> { return EV_9; }
            case  10 -> { return EV_10; }
            case  11 -> { return EV_11; }
            case  12 -> { return EV_12; }
            case  13 -> { return EV_13; }
            case  14 -> { return EV_14; }
            case  15 -> { return EV_15; }
            case  16 -> { return EV_16; }
            case  17 -> { return EV_17; }
            case  18 -> { return EV_18; }
            case  19 -> { return EV_19; }
            case  20 -> { return EV_20; }
            default  -> { return EV.NOT_FOUND; }
        }
    }

    public static final EV fromValue(final double value) {
        return fromValue(Helper.round(value));
    }

    @Override public String toString() {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("ui_string").append(QUOTES).append(COLON).append(QUOTES).append(uiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("api_string").append(QUOTES).append(COLON).append(QUOTES).append(apiString).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("description").append(QUOTES).append(COLON).append(QUOTES).append(description).append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("value").append(QUOTES).append(COLON).append(value)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }
}
