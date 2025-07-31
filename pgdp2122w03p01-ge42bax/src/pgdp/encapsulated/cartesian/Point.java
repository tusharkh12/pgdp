package pgdp.encapsulated.cartesian;

import pgdp.MathHelpers;

public class Point {

    private double x;
    private double y;

    /*  Konstruktor nimmt x und y entgegen, worauf sich der Nutzer
     *  der Bibliothek verlässt. Das muss beim Umschreiben der Klasse
     *  berücksichtigt werden.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //  Reguläre Getter für x und y
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //  Reguläre Setter für x und y
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    //  Distanz zum Ursprung
    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    /*  Distanz zum Punkt 'other'
     *  Hinweis: 'other.x' ist trotz der Tatsache, dass x ein privates Attribut ist,
     *           erlaubt, da wir uns hier immer noch in der Klasse 'Point' befinden.
     *           Ob der Variablenzugriff auf das eigene oder ein anderes Objekt
     *           gerichtet ist, spielt keine Rolle.
     */
    public double distanceTo(Point other) {
        double dx = x - other.x;
        double dy = y - other.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

}
