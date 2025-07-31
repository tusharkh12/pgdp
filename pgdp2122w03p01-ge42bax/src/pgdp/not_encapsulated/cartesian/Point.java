package pgdp.not_encapsulated.cartesian;

import pgdp.MathHelpers;

public class Point {

    public double x;
    public double y;

    /*  Konstruktor nimmt x und y entgegen, worauf sich der Nutzer
     *  der Bibliothek verlässt. Das muss beim Umschreiben der Klasse
     *  berücksichtigt werden.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //  Distanz zum Ursprung
    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    //  Distanz zum Punkt 'other'
    public double distanceTo(Point other) {
        double dx = x - other.x;
        double dy = y - other.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

}
