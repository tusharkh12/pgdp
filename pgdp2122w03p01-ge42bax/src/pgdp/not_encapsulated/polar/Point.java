package pgdp.not_encapsulated.polar;

import pgdp.MathHelpers;

public class Point {



    public double radius;
    public double angle;

    public Point(double x, double y) {
        angle = MathHelpers.xyToAngle(x, y);
        radius = MathHelpers.xyToRadius(x, y);
    }

    public double getX() {
        return MathHelpers.angleRadiusToX(angle, radius);
    }

    public double getY() {
        return MathHelpers.angleRadiusToY(angle, radius);
    }


    public double distanceToOrigin() {
        return radius;
    }


    public double distanceTo(Point other) {
        double dx = getX() - other.getX();
        double dy = getY() - other.getY();

        return MathHelpers.xyToRadius(dx, dy);
    }

}