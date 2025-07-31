package pgdp.triangles;

import java.awt.*;
import java.util.Vector;

public class Triangle {
    private Point2D a;
    private Point2D b;
    private Point2D c;

    public Triangle(Point2D a, Point2D b, Point2D c) {
        this.a = a;
        this.b = b;
        this.c = c;

        checkValidity();
    }

    public Vector2D getAB() {
        checkValidity();

        return b.vectorFrom(a);
    }

    public Vector2D getAC() {
        checkValidity();

        return c.vectorFrom(a);
    }

    public Vector2D getBC() {
        checkValidity();

        return c.vectorFrom(b);
    }

    public double getAngleAtA() {
        checkValidity();

        Vector2D ab = getAB();
        Vector2D ac = getAC();

        return Math.acos(ab.dot(ac) / (ab.length() * ac.length()));
    }

    public double getArea() {
        checkValidity();

        double base = getAC().length();
        double height = getAB().length() * Math.sin(getAngleAtA());

        return 0.5 * base * height;
    }

    public boolean isScalene() {
        checkValidity();

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        if (Math.abs(ab - ac) > delta && Math.abs(ab - bc) > delta && Math.abs(ac - bc) > delta) {
            return true;
        }
        return false;
    }

    public boolean isIsosceles() {
        checkValidity();

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        if (Math.abs(ab - ac) < delta) {
            return true;
        }
        if (Math.abs(ab - bc) < delta) {
            return true;
        }
        if (Math.abs(ac - bc) < delta) {
            return true;
        }
        return false;
    }

    public boolean isEquilateral() {
        checkValidity();

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        if (Math.abs(ab - ac) < delta && Math.abs(ab - bc) < delta) {
            return true;
        }
        return false;
    }

    public Point2D getA() {
        checkValidity();

        return a;
    }

    public void setA(Point2D a) {
        Point2D tmp = this.a;
        this.a = a;
        if(!isValidTriangle()) {
            System.out.println("Ungültiges Dreieck!");
            this.a = tmp;
        }
    }

    public Point2D getB() {
        checkValidity();

        return b;
    }

    public void setB(Point2D b) {
        Point2D tmp = this.b;
        this.b = b;
        if(!isValidTriangle()) {
            System.out.println("Ungültiges Dreieck!");
            this.b = tmp;
        }
    }

    public Point2D getC() {
        checkValidity();

        return c;
    }

    public void setC(Point2D c) {
        Point2D tmp = this.c;
        this.c = c;
        if(!isValidTriangle()) {
            System.out.println("Ungültiges Dreieck!");
            this.c = tmp;
        }
    }

    public boolean isValidTriangle() {
        double delta = 1e-12;

        Vector2D ab = b.vectorFrom(a);
        Vector2D ac = c.vectorFrom(a);

        if(Math.abs(ab.length()) < delta || Math.abs(ac.length()) < delta) {
            return false;
        }

        if(Math.abs(ab.getY()) < delta && Math.abs(ac.getY()) < delta) {
            return false;
        }
        
        if (Math.abs(ab.getX() / ab.getY() - ac.getX() / ac.getY()) < delta) {
            return false;
        }

        return true;
    }
  
  	  
  	// Diese Methode muss nicht getestet werden, sie macht nur den Code schöner und kürzer
  	private void checkValidity() {
    	if(!isValidTriangle()) {
            System.out.println("Ungültiges Dreieck!");
        }
    }
}
