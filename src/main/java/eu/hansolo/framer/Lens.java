package eu.hansolo.framer;

public class Lens {
    private String  name;
    private double  minFocalLength;
    private double  maxFocalLength;
    private double  minAperture;
    private double  maxAperture;
    private double  focalLength;
    private double  aperture;
    private boolean prime;


    public Lens() {
        this("Lens", 8, 1000, 0.7, 50);
    }
    public Lens(final String name, final double focalLength, final double minAperture, final double maxAperture) {
        this(name, focalLength, focalLength, minAperture, maxAperture);
    }
    public Lens(final String name, final double minFocalLength, final double maxFocalLength, final double minAperture, final double maxAperture) {
        this.name           = name;
        this.minFocalLength = minFocalLength;
        this.maxFocalLength = maxFocalLength;
        this.minAperture    = minAperture;
        this.maxAperture    = maxAperture;
        this.prime          = Double.compare(minFocalLength, maxFocalLength) == 0;
        this.focalLength    = minFocalLength;
        this.aperture       = minAperture;
    }

    public String getName() { return name; }
    public void setName(final String name) { this.name = name; }

    public double getMinFocalLength() {
        return minFocalLength;
    }
    public void setMinFocalLength(final double minFocalLength) {
        this.minFocalLength = minFocalLength;
    }

    public double getMaxFocalLength() {
        return maxFocalLength;
    }
    public void setMaxFocalLength(final double maxFocalLength) {
        this.maxFocalLength = maxFocalLength;
    }

    public double getMinAperture() {
        return minAperture;
    }
    public void setMinAperture(final double minAperture) {
        this.minAperture = minAperture;
    }

    public double getMaxAperture() {
        return maxAperture;
    }
    public void setMaxAperture(final double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public double getFocalLength() {
        return focalLength;
    }
    public void setFocalLength(final double focalLength) {
        this.focalLength = Helper.clamp(minFocalLength, maxFocalLength, focalLength);
    }

    public double getAperture() {
        return aperture;
    }
    public void setAperture(final double aperture) {
        this.aperture = Helper.clamp(minAperture, maxAperture, aperture);
    }

    public boolean isPrime() {
        return prime;
    }
}
