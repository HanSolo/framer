package eu.hansolo.framer;

import java.util.Objects;

import static eu.hansolo.toolbox.Constants.COLON;
import static eu.hansolo.toolbox.Constants.COMMA;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_CLOSE;
import static eu.hansolo.toolbox.Constants.CURLY_BRACKET_OPEN;
import static eu.hansolo.toolbox.Constants.QUOTES;


public class GeoLocation {
    private double latitude;
    private double longitude;
    private double elevation;


    // ******************** Constructors **************************************
    public GeoLocation() {
        this(0, 0, 0);
    }
    public GeoLocation(final double latitude, final double longitude) {
        this(latitude, longitude, 0);
    }
    public GeoLocation(final double latitude, final double longitude, final double elevation) {
        this.latitude  = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }


    // ******************** Methods *******************************************
    public double getLatitude() { return latitude; }
    public void setLatitude(final double latitude) { this.latitude = Helper.clampLatitude(latitude); }

    public double getLongitude() { return longitude; }
    public void setLongitude(final double longitude) { this.longitude = Helper.clampLongitude(longitude); }

    public double getElevation() { return elevation; }
    public void setElevation(final double elevation) { this.elevation   = elevation; }

    public void set(final double latitude, final double longitude) {
        set(latitude, longitude, getElevation());
    }
    public void set(final double latitude, final double longitude, final double elevation) {
        this.latitude  = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }
    public void set(final GeoLocation location) {
        latitude  = location.getLatitude();
        longitude = location.getLongitude();
        elevation = location.getElevation();
    }

    public double getDistanceTo(final GeoLocation location) { return Helper.calcDistanceInMetersPrecise(this, location); }

    public boolean isWithinRangeOf(final GeoLocation location, final double meters) { return getDistanceTo(location) < meters; }

    public double getAltitudeDifferenceInMeter(final GeoLocation location) { return (elevation - location.getElevation()); }

    public double getBearingTo(final GeoLocation location) {
        return Helper.calcBearingInDegree(getLatitude(), getLongitude(), location.getLatitude(), location.getLongitude());
    }
    public double getBearingTo(final double latitude, final double longitude) {
        return Helper.calcBearingInDegree(getLatitude(), getLongitude(), latitude, longitude);
    }

    public boolean isZero() { return Double.compare(latitude, 0d) == 0 && Double.compare(longitude, 0d) == 0; }

    public GeoLocation getCopy() {
        return new GeoLocation(this.latitude, this.longitude, this.elevation);
    }


    // ******************** Misc **********************************************
    @Override public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GeoLocation that = (GeoLocation) o;
        return Double.compare(that.latitude, latitude) == 0 && Double.compare(that.longitude, longitude) == 0 && Double.compare(that.elevation, elevation) == 0;
    }

    @Override public int hashCode() {
        return Objects.hash(latitude, longitude, elevation);
    }

    @Override public String toString() {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("latitude").append(QUOTES).append(COLON).append(latitude).append(COMMA)
                                  .append(QUOTES).append("longitude").append(QUOTES).append(COLON).append(longitude).append(COMMA)
                                  .append(QUOTES).append("elevation").append(QUOTES).append(COLON).append(elevation)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }
}
