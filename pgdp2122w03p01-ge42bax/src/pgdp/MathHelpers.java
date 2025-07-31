package pgdp;

public class MathHelpers {
    // Helper methods for computing polar from cartesian coordinates
    public static double xyToAngle(double x, double y) {
        if (x > 0) {
            return Math.atan(y / x);
        } else if (x == 0) {
            return Math.signum(y) * Math.PI / 2;
        } else {
            return Math.atan(y / x) + Math.PI;
        }
    }

    public static double xyToRadius(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    // Helper methods for computing cartesian from polar coordinates
    public static double angleRadiusToX(double angle, double radius) {
        return Math.cos(angle) * radius;
    }

    public static double angleRadiusToY(double angle, double radius) {
        return Math.sin(angle) * radius;
    }
}
