package eu.hansolo.framer;

import static eu.hansolo.toolbox.Constants.*;


public class Lens {
    private String  name;
    private int     minFocalLength;
    private int     maxFocalLength;
    private double  minAperture;
    private double  maxAperture;


    // ******************** Constructors **************************************
    public Lens() {
        this("Lens", 70, 200, 2.8, 32);
    }
    public Lens(final String name, final int focalLength, final int minAperture, final double maxAperture) {
        this(name, focalLength, focalLength, minAperture, maxAperture);
    }
    public Lens(final String name, final int focalLength, final double aperture) {
        if (null           == name) { throw new IllegalArgumentException("name cannot be null"); }
        if (focalLength < Constants.MIN_FOCAL_LENGTH) { throw new IllegalArgumentException("focalLength cannot be smaller than " + Constants.MIN_FOCAL_LENGTH + "mm"); }
        if (focalLength > Constants.MAX_FOCAL_LENGTH) { throw new IllegalArgumentException("focalLength cannot be greater than " + Constants.MAX_FOCAL_LENGTH + "mm"); }
        if (aperture    < Constants.MIN_APERTURE)     { throw new IllegalArgumentException("aperture cannot be smaller than f/" + Constants.MIN_APERTURE); }
        if (aperture    > Constants.MAX_APERTURE)     { throw new IllegalArgumentException("aperture cannot be greater than f/" + Constants.MAX_APERTURE); }
        this.name           = name;
        this.minFocalLength = focalLength;
        this.maxFocalLength = focalLength;
        this.minAperture    = aperture;
        this.maxAperture    = aperture;
    }
    public Lens(final String name, final int minFocalLength, final int maxFocalLength, final double minAperture, final double maxAperture) {
        if (null           == name) { throw new IllegalArgumentException("name cannot be null"); }
        if (minFocalLength < Constants.MIN_FOCAL_LENGTH) { throw new IllegalArgumentException("minFocalLength cannot be smaller than " + Constants.MIN_FOCAL_LENGTH + "mm"); }
        if (maxFocalLength > Constants.MAX_FOCAL_LENGTH) { throw new IllegalArgumentException("maxFocalLength cannot be greater than " + Constants.MAX_FOCAL_LENGTH + "mm"); }
        if (minAperture    < Constants.MIN_APERTURE)     { throw new IllegalArgumentException("minAperture cannot be smaller than f/" + Constants.MIN_APERTURE); }
        if (maxAperture    > Constants.MAX_APERTURE)     { throw new IllegalArgumentException("maxAperture cannot be greater than f/" + Constants.MAX_APERTURE); }
        this.name           = name;
        this.minFocalLength = minFocalLength;
        this.maxFocalLength = maxFocalLength;
        this.minAperture    = minAperture;
        this.maxAperture    = maxAperture;
    }


    // ******************** Methods *******************************************
    public String getName() { return name; }
    public void setName(final String name) { this.name = null == name ? "Lens" : name; }

    public int getFocalLength() { return minFocalLength; }
    public void setFocalLength(final int focalLength) {
        setMinFocalLength(focalLength);
        setMaxFocalLength(focalLength);
    }

    public int getMinFocalLength() { return minFocalLength; }
    public void setMinFocalLength(final int minFocalLength) { this.minFocalLength = Helper.clamp(Constants.MIN_FOCAL_LENGTH, Constants.MAX_FOCAL_LENGTH, minFocalLength); }

    public int getMaxFocalLength() { return maxFocalLength; }
    public void setMaxFocalLength(final int maxFocalLength) { this.maxFocalLength = Helper.clamp(Constants.MIN_FOCAL_LENGTH, Constants.MAX_FOCAL_LENGTH, maxFocalLength); }

    public double getAperture() { return minAperture; }
    public void setAperture(final double aperture) {
        setMinAperture(aperture);
        setMaxAperture(aperture);
    }

    public double getMinAperture() { return minAperture; }
    public void setMinAperture(final double minAperture) { this.minAperture = Helper.clamp(Constants.MIN_APERTURE, Constants.MAX_APERTURE, minAperture); }

    public double getMaxAperture() { return maxAperture; }
    public void setMaxAperture(final double maxAperture) { this.maxAperture = Helper.clamp(Constants.MIN_APERTURE, Constants.MAX_APERTURE, maxAperture); }

    public boolean isPrime() { return minFocalLength == maxFocalLength; }

    @Override public String toString() {
        final boolean isPrime = isPrime();
        StringBuilder msg = new StringBuilder().append(CURLY_BRACKET_OPEN)
                                               .append(QUOTES).append("name").append(QUOTES).append(COLON).append(QUOTES).append(name).append(QUOTES).append(COMMA)
                                               .append(QUOTES).append("prime").append(QUOTES).append(COLON).append(isPrime).append(COMMA);
        if (isPrime) {
            msg.append(QUOTES).append("focal_length").append(QUOTES).append(COLON).append(minFocalLength).append(COMMA)
               .append(QUOTES).append("aperture").append(QUOTES).append(COLON).append(minAperture);
        } else {
            msg.append(QUOTES).append("min_focal_length").append(QUOTES).append(COLON).append(minFocalLength).append(COMMA)
               .append(QUOTES).append("max_focal_length").append(QUOTES).append(COLON).append(maxFocalLength).append(COMMA)
               .append(QUOTES).append("min_aperture").append(QUOTES).append(COLON).append(minAperture).append(COMMA)
               .append(QUOTES).append("max_aperture").append(QUOTES).append(COLON).append(maxAperture);
        }
        msg.append(CURLY_BRACKET_CLOSE);
        return msg.toString();
    }
}
