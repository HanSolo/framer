package eu.hansolo.framer;

import java.util.List;

import static eu.hansolo.toolbox.Constants.*;


public class Trapezoid {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private double x4;
    private double y4;


    // ******************** Constructors **************************************
    public Trapezoid() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }
    public Trapezoid(final double[] points) {
        this(points[0], points[1], points[2], points[3], points[4], points[5], points[6], points[7]);
    }
    public Trapezoid(final double x1, final double y1, final double x2, final double y2, final double x3, final double y3, final double x4, final double y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }


    // ******************** Methods *******************************************
    public double getX1() {
        return x1;
    }
    public void setX1(final double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }
    public void setY1(final double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }
    public void setX2(final double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }
    public void setY2(final double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }
    public void setX3(final double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }
    public void setY3(final double y3) {
        this.y3 = y3;
    }

    public double getX4() {
        return x4;
    }
    public void setX4(final double x4) {
        this.x4 = x4;
    }

    public double getY4() {
        return y4;
    }
    public void setY4(final double y4) {
        this.y4 = y4;
    }

    public double[] getPoints() {
        return new double[] { x1, y1, x2, y2, x3, y3, x4, y4 };
    }
    public List<Double> getPointsAsList() {
        return List.of(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    @Override public String toString() {
        return new StringBuilder().append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("type").append(QUOTES).append(COLON).append(QUOTES).append("Feature").append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("geometry").append(QUOTES).append(COLON).append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("type").append(QUOTES).append(COLON).append(QUOTES).append("Polygon").append(QUOTES).append(COMMA)
                                  .append(QUOTES).append("coordinates").append(QUOTES).append(COLON).append(SQUARE_BRACKET_OPEN)
                                  .append(SQUARE_BRACKET_OPEN)
                                  .append(SQUARE_BRACKET_OPEN).append(x1).append(COMMA).append(y1).append(SQUARE_BRACKET_CLOSE).append(COMMA)
                                  .append(SQUARE_BRACKET_OPEN).append(x2).append(COMMA).append(y2).append(SQUARE_BRACKET_CLOSE).append(COMMA)
                                  .append(SQUARE_BRACKET_OPEN).append(x3).append(COMMA).append(y3).append(SQUARE_BRACKET_CLOSE).append(COMMA)
                                  .append(SQUARE_BRACKET_OPEN).append(x4).append(COMMA).append(y4).append(SQUARE_BRACKET_CLOSE)
                                  .append(SQUARE_BRACKET_CLOSE)
                                  .append(SQUARE_BRACKET_CLOSE)
                                  .append(CURLY_BRACKET_CLOSE).append(COMMA)
                                  .append(QUOTES).append("properties").append(QUOTES).append(COLON).append(CURLY_BRACKET_OPEN)
                                  .append(QUOTES).append("name").append(QUOTES).append(COLON).append(QUOTES).append("dofTrapezoid").append(QUOTES)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .append(CURLY_BRACKET_CLOSE)
                                  .toString();
    }
}
