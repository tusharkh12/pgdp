package pgdp.encapsulated.polar;

import pgdp.MathHelpers;

public class Point {

    private double radius;
    private double angle;


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


    public void setX(double x) {

        double y = getY();
        angle = MathHelpers.xyToAngle(x, y);
        radius = MathHelpers.xyToRadius(x, y);
    }

    public void setY(double y) {

        double x = getX();
        angle = MathHelpers.xyToAngle(x, y);
        radius = MathHelpers.xyToRadius(x, y);
    }


    public double getRadius() {
        return radius;
    }

    public double getAngle() {
        return angle;
    }

    public void setRadius(double radius) {
        this.radius=radius;
    }

    public void setAngle(double angle) {
        this.angle=angle;
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