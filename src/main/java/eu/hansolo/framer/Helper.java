package eu.hansolo.framer;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Helper {

    public static final int clamp(final int min, final int max, final int value) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
    public static final double clamp(final double min, final double max, final double value) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
    public static final double clampLatitude(final double latitude) {
        if (latitude < -90) {
            return -90 - (latitude % 90);
        } else if (latitude > 90) {
            return 90 - (latitude % 90);
        } else {
            return latitude;
        }
    }
    public static final double clampLongitude(final double longitude) {
        if (longitude < -180) {
            return 180 + (longitude % 180);
        } else if (longitude > 180) {
            return -180 + (longitude % 180);
        } else {
            return longitude;
        }
    }

    public  static final double round(final double value, final int places) {
        if (places < 0) throw new IllegalArgumentException("Number of places cannot be smaller than 0");
        BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static final double calcDistanceInKilometers(final GeoLocation location1, final GeoLocation location2) {
        return calcDistanceInMeters(location1, location2) / 1000.0;
    }
    public static final double calcDistanceInMeters(final GeoLocation location1, final GeoLocation location2) {
        return calcDistanceInMeters(location1.getLatitude(), location1.getLongitude(), location2.getLatitude(), location2.getLongitude());
    }
    public static final double calcDistanceInMeters(final double latitude1, final double longitude1, final double latitude2, final double longitude2) {
        final double lat1Radians     = Math.toRadians(latitude1);
        final double lat2Radians     = Math.toRadians(latitude2);
        final double deltaLatRadians = Math.toRadians(latitude2 - latitude1);
        final double deltaLonRadians = Math.toRadians(longitude2 - longitude1);

        final double a = Math.sin(deltaLatRadians * 0.5) * Math.sin(deltaLatRadians * 0.5) + Math.cos(lat1Radians) * Math.cos(lat2Radians) * Math.sin(deltaLonRadians * 0.5) * Math.sin(deltaLonRadians * 0.5);
        final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        final double distance = Constants.WGS84_a * c;
        return distance;
    }

    public static double calcDistanceInMetersMorePrecise(final GeoLocation location1, final GeoLocation location2) {
        return calcDistanceInMetersMorePrecise(location1.getLatitude(), location1.getLongitude(), location2.getLatitude(), location2.getLongitude());
    }
    public static double calcDistanceInMetersMorePrecise(double latitude1, double longitude1, double latitude2, double longitude2) {
        final int    maxIterations      = 20;

        final double lat1               = Math.toRadians(latitude1);
        final double lat2               = Math.toRadians(latitude2);
        final double lon1               = Math.toRadians(longitude1);
        final double lon2               = Math.toRadians(longitude2);

        final double f                  = (Constants.WGS84_a - Constants.WGS84_b) / Constants.WGS84_a;
        final double aSqMinusBSqOverBSq = (Constants.WGS84_a * Constants.WGS84_a - Constants.WGS84_b * Constants.WGS84_b) / (Constants.WGS84_b * Constants.WGS84_b);

        final double L                  = lon2 - lon1;
        final double U1                 = Math.atan((1.0 - f) * Math.tan(lat1));
        final double U2                 = Math.atan((1.0 - f) * Math.tan(lat2));

        final double cosU1              = Math.cos(U1);
        final double cosU2              = Math.cos(U2);
        final double sinU1              = Math.sin(U1);
        final double sinU2              = Math.sin(U2);
        final double cosU1cosU2         = cosU1 * cosU2;
        final double sinU1sinU2         = sinU1 * sinU2;

        double A                        = 0.0;
        double sigma                    = 0.0;
        double deltaSigma               = 0.0;
        double cosSqAlpha               = 0.0;
        double cos2SM                   = 0.0;
        double cosSigma                 = 0.0;
        double sinSigma                 = 0.0;
        double cosLambda                = 0.0;
        double sinLambda                = 0.0;
        double lambda                   = L;

        for (int iter = 0; iter < maxIterations; iter++) {
            final double lambdaOrig = lambda;
            cosLambda = Math.cos(lambda);
            sinLambda = Math.sin(lambda);

            final double t1         = cosU2 * sinLambda;
            final double t2         = cosU1 * sinU2 - sinU1 * cosU2 * cosLambda;
            final double sinSqSigma = t1 * t1 + t2 * t2;
            sinSigma = Math.sqrt(sinSqSigma);
            cosSigma = sinU1sinU2 + cosU1cosU2 * cosLambda;
            sigma    = Math.atan2(sinSigma, cosSigma);

            final double sinAlpha = (sinSigma == 0) ? 0.0 : cosU1cosU2 * sinLambda / sinSigma;
            cosSqAlpha = 1.0 - sinAlpha * sinAlpha;
            cos2SM     = (cosSqAlpha == 0) ? 0.0 : cosSigma - 2.0 * sinU1sinU2 / cosSqAlpha;

            final double uSquared = cosSqAlpha * aSqMinusBSqOverBSq;
            A = 1 + (uSquared / 16384.0) * (4096.0 + uSquared * (-768 + uSquared * (320.0 - 175.0 * uSquared)));

            final double B        = (uSquared / 1024.0) * (256.0 + uSquared * (-128.0 + uSquared * (74.0 - 47.0 * uSquared)));
            final double C        = (f / 16.0) * cosSqAlpha * (4.0 + f * (4.0 - 3.0 * cosSqAlpha));
            final double cos2SMSq = cos2SM * cos2SM;
            deltaSigma = B * sinSigma * (cos2SM + (B / 4.0) * (cosSigma * (-1.0 + 2.0 * cos2SMSq) - (B / 6.0) * cos2SM * (-3.0 + 4.0 * sinSigma * sinSigma) * (-3.0 + 4.0 * cos2SMSq)));
            lambda     = L + (1.0 - C) * f * sinAlpha * (sigma + C * sinSigma * (cos2SM + C * cosSigma * (-1.0 + 2.0 * cos2SM * cos2SM)));

            final double delta = (lambda - lambdaOrig) / lambda;
            if (Math.abs(delta) < 1.0e-12) { break; }
        }

        double distance = (Constants.WGS84_b * A * (sigma - deltaSigma));
        return distance;
    }

    public static final double calcBearingInDegree(final GeoLocation location1, final GeoLocation location2) {
        return calcBearingInDegree(location1.getLatitude(), location1.getLongitude(), location2.getLatitude(), location2.getLongitude());
    }
    public static final double calcBearingInDegree(final double latitude1, final double longitude1, final double latitude2, final double longitude2) {
        double lat1     = Math.toRadians(latitude1);
        double lon1     = Math.toRadians(longitude1);
        double lat2     = Math.toRadians(latitude2);
        double lon2     = Math.toRadians(longitude2);
        double deltaLon = lon2 - lon1;
        double deltaPhi = Math.log(Math.tan(lat2 * 0.5 + Math.PI * 0.25) / Math.tan(lat1 * 0.5 + Math.PI * 0.25));
        if (Math.abs(deltaLon) > Math.PI) {
            if (deltaLon > 0) {
                deltaLon = -(2.0 * Math.PI - deltaLon);
            } else {
                deltaLon = (2.0 * Math.PI + deltaLon);
            }
        }
        double bearing = (Math.toDegrees(Math.atan2(deltaLon, deltaPhi)) + 360.0) % 360.0;
        return bearing;
    }

    public static final CardinalDirection getCardinalDirectionFromBearing(final double bearing) {
        final double brng = bearing % 360.0;
        for (CardinalDirection cardinalDirection : CardinalDirection.values()) {
            if (Double.compare(brng, cardinalDirection.from) >= 0 && Double.compare(brng, cardinalDirection.to) < 0) { return cardinalDirection; }
        }
        return CardinalDirection.NOT_FOUND;
    }

    public static final double[] rotateCoordinate(final double rotationCenterLatitude, final double rotationCenterLongitude,
                                                  final double pointToRotateLatitude, final double pointToRotateLongitude,
                                                  final double angleInDegree) {
        final double lat1Rad      = Math.toRadians(rotationCenterLatitude);
        final double lon1Rad      = Math.toRadians(rotationCenterLongitude);
        final double angleInRad   = Math.toRadians(angleInDegree);
        final double distance     = calcDistanceInMetersMorePrecise(rotationCenterLatitude, rotationCenterLongitude, pointToRotateLatitude, pointToRotateLongitude);
        final double centralAngle = distance / Constants.WGS84_a;
        final double lat2Rad      = Math.asin(Math.sin(lat1Rad) * Math.cos(centralAngle) + Math.cos(lat1Rad) * Math.sin(centralAngle) * Math.cos(angleInRad));
        final double lon2Rad      = lon1Rad + Math.atan2(Math.sin(angleInRad) * Math.sin(centralAngle) * Math.cos(lat1Rad), Math.cos(centralAngle) - Math.sin(lat1Rad) * Math.sin(lat2Rad));
        return new double[] { Math.toDegrees(lat2Rad), Math.toDegrees(lon2Rad) };
    }

    public static final GeoLocation rotateCoordinate(final GeoLocation rotationCenter, final GeoLocation pointToRotate, final double bearing) {
        final double lat1         = Math.toRadians(rotationCenter.getLatitude());
        final double lon1         = Math.toRadians(rotationCenter.getLongitude());
        final double distance     = calcDistanceInMetersMorePrecise(rotationCenter, pointToRotate);
        final double centralAngle = distance / Constants.WGS84_a;
        final double lat2         = Math.asin(Math.sin(lat1) * Math.cos(centralAngle) + Math.cos(lat1) * Math.sin(centralAngle) * Math.cos(Math.toRadians(bearing)));
        final double lon2         = lon1 + Math.atan2(Math.sin(Math.toRadians(bearing)) * Math.sin(centralAngle) * Math.cos(lat1), Math.cos(centralAngle) - Math.sin(lat1) * Math.sin(lat2));
        return new GeoLocation(Math.toDegrees(lat2), Math.toDegrees(lon2));
    }

    public static final Triangle getFoVTriangle(final FovData fovData) {
        double[] trianglePoints = calcTrianglePoints(fovData);
        return new Triangle(trianglePoints);
    }
    public static final double[] calcTrianglePoints(final FovData fovData) {
        final double halfFovWidthAngle = fovData.fovWidthAngle / 2.0;
        double[] p2 = calcCoordinates(fovData.cameraLocation, fovData.radius, -halfFovWidthAngle);
        double[] p3 = calcCoordinates(fovData.cameraLocation, fovData.radius, halfFovWidthAngle);

        //double[] rotatedP2 = rotateCoordinate(fovData.cameraLocation.getLatitude(), fovData.cameraLocation.getLongitude(), p2[0], p2[1],fovData.bearing);
        //double[] rotatedP3 = rotateCoordinate(fovData.cameraLocation.getLatitude(), fovData.cameraLocation.getLongitude(), p3[0], p3[1],fovData.bearing);
        //return new double[] { fovData.cameraLocation.getLatitude(), fovData.cameraLocation.getLongitude(), rotatedP2[0], rotatedP2[1], rotatedP3[0], rotatedP3[1] };
        return new double[] { fovData.cameraLocation.getLatitude(), fovData.cameraLocation.getLongitude(), p2[0], p2[1], p3[0], p3[1] };
    }

    public static final Trapezoid getDofTrapezoid(final FovData fovData) {
        double[] trapezoidPoints = calcTrapezoidPoints(fovData);
        return new Trapezoid(trapezoidPoints);
    }
    public static final double[] calcTrapezoidPoints(final FovData fovData) {
        final double halfFovWidthAngle = fovData.fovWidthAngle / 2.0;
        final double radius1           = fovData.dofNearLimit / Math.cos(halfFovWidthAngle);
        final double radius2           = fovData.dofFarLimit / Math.cos(halfFovWidthAngle);

        final double p1[] = calcCoordinates(fovData.cameraLocation, radius1, -halfFovWidthAngle);
        final double p2[] = calcCoordinates(fovData.cameraLocation, radius2, -halfFovWidthAngle);
        final double p3[] = calcCoordinates(fovData.cameraLocation, radius2, halfFovWidthAngle);
        final double p4[] = calcCoordinates(fovData.cameraLocation, radius1, halfFovWidthAngle);

        //double[] rotatedP1 = rotateCoordinate(fovData.cameraLocation.getLatitude(), fovData.cameraLocation.getLongitude(), p1[0], p1[1],fovData.bearing);
        //double[] rotatedP2 = rotateCoordinate(fovData.cameraLocation.getLatitude(), fovData.cameraLocation.getLongitude(), p2[0], p2[1],fovData.bearing);
        //double[] rotatedP3 = rotateCoordinate(fovData.cameraLocation.getLatitude(), fovData.cameraLocation.getLongitude(), p3[0], p3[1],fovData.bearing);
        //double[] rotatedP4 = rotateCoordinate(fovData.cameraLocation.getLatitude(), fovData.cameraLocation.getLongitude(), p4[0], p4[1],fovData.bearing);

        //return new double[] { rotatedP1[0], rotatedP1[1], rotatedP2[0], rotatedP2[1], rotatedP3[0], rotatedP3[1], rotatedP4[0], rotatedP4[1] };
        return new double[] { p1[0], p1[1], p2[0], p2[1], p3[0], p3[1], p4[0], p4[1] };
    }

    public static final double[] calcCoordinates(final GeoLocation start, final double distance, final double bearing) {
        double lat1   = Math.toRadians(start.getLatitude());
        double lon1   = Math.toRadians(start.getLongitude());
        double radius = distance / Constants.WGS84_a;

        double lat2 = Math.asin(Math.sin(lat1) * Math.cos(radius) + Math.cos(lat1) * Math.sin(radius) * Math.cos(bearing));
        double lon2 = lon1 + Math.atan2(Math.sin(bearing) * Math.sin(radius) * Math.cos(lat1), Math.cos(radius) - Math.sin(lat1) * Math.sin(lat2));
        lon2 = (lon2 + 3 * Math.PI) % (2 * Math.PI) - Math.PI;

        return new double[] { Math.toDegrees(lat2), Math.toDegrees(lon2) };
    }

    public static final FovData calc(final GeoLocation cameraLocation, final GeoLocation subjectLocation,
                                     final int focalLength, final double aperture,
                                     final SensorFormat sensorFormat, final Orientation orientation) {

        final double distance = cameraLocation.getDistanceTo(subjectLocation);

        if (focalLength < Constants.MIN_FOCAL_LENGTH || focalLength > Constants.MAX_FOCAL_LENGTH) { throw new IllegalArgumentException(new StringBuilder("Error, focal length must be between ").append(Constants.MIN_FOCAL_LENGTH).append("mm and ").append(Constants.MAX_FOCAL_LENGTH).append("mm").toString()); }
        if (aperture    < Constants.MIN_APERTURE     || aperture    > Constants.MAX_APERTURE)     { throw new IllegalArgumentException(new StringBuilder("Error, aperture must be between f/").append(Constants.MIN_APERTURE).append(" and f/").append(Constants.MAX_APERTURE).toString()); }
        if (distance    < Constants.MIN_DISTANCE     || distance    > Constants.MAX_DISTANCE)     { throw new IllegalArgumentException(new StringBuilder("Error, distance must be between ").append(Constants.MIN_DISTANCE).append("m and ").append(Constants.MAX_DISTANCE + "m").toString()); }

        final double cropFactor         = sensorFormat.cropFactor;
        final double focalLengthInMeter = focalLength / 1000.0;           // Do all calculations in metres (because that's sensible).
        final double circleOfConfusion  = (0.0290 / 1000.0) / cropFactor; // Let the circle of confusion be 0.0290mm for 35mm film.
        final double hyperFocal         = (focalLengthInMeter * focalLengthInMeter) / (aperture * circleOfConfusion) + focalLengthInMeter;
        final double nearLimit          = ((hyperFocal - focalLengthInMeter) * distance) / (hyperFocal + distance - 2 * focalLengthInMeter);
        final boolean infinite          = (hyperFocal - distance) < 0.00000001;
        final double farLimit           = ((hyperFocal - focalLengthInMeter) * distance) / (hyperFocal - distance);
        final double frontPercent       = (distance - nearLimit) / (farLimit - nearLimit) * 100;
        final double behindPercent      = (farLimit - distance) / (farLimit - nearLimit) * 100;
        final double total              = farLimit - nearLimit;
        final double d                  = Math.sqrt((sensorFormat.width * sensorFormat.width) + (sensorFormat.height * sensorFormat.height));
        final double diagonalAngle      = 2.0 * Math.atan(d / (2.0 * focalLengthInMeter));
        final double diagonalLength     = (((distance * Math.sin(diagonalAngle / 2.0)) / Math.cos(diagonalAngle / 2.0)) * 2.0) / 1000;
        final double phi                = Math.asin(2.0 / 3.605551);
        final double fovWidth           = Orientation.LANDSCAPE == orientation ? Math.cos(phi) * diagonalLength : Math.sin(phi) * diagonalLength;
        final double fovHeight          = Orientation.LANDSCAPE == orientation ? Math.sin(phi) * diagonalLength : Math.cos(phi) * diagonalLength;
        final double halfFovWidth       = fovWidth * 0.5;
        final double halfFovHeight      = fovHeight * 0.5;
        final double fovWidthAngle      = 2 * Math.asin(halfFovWidth / Math.sqrt((distance * distance) + (halfFovWidth * halfFovWidth)));
        final double fovHeightAngle     = 2 * Math.asin(halfFovHeight / Math.sqrt((distance * distance) + (halfFovHeight * halfFovHeight)));
        final double maxSubjectHeight   = halfFovHeight < Constants.CAMERA_HEIGHT ? fovHeight : Constants.CAMERA_HEIGHT + halfFovHeight;
        final double radius             = Math.sqrt((halfFovWidth * halfFovWidth) + (distance * distance));

        return new FovData(cameraLocation, subjectLocation, focalLengthInMeter, aperture, sensorFormat, orientation, infinite, hyperFocal, nearLimit, farLimit, frontPercent, behindPercent, total, diagonalAngle, diagonalLength, fovWidth, fovWidthAngle, fovHeight, fovHeightAngle, maxSubjectHeight, radius);
    }
}
