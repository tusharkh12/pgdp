package pgdp.triangles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pgdp.PinguLib;

import java.lang.reflect.Constructor;

public class TriangleTest {
    // ***********************************
    // DO NOT DELETE OR CHANGE THE FOLLOWING LINES
    // ***********************************
    @BeforeEach
    void setup() {
        PinguLib.setup();
    }
    
    @AfterEach
    void reset() {
        PinguLib.reset();
    }
    // ***********************************

    /*  Beispiel für einen Kommentar, warum dieser eine Test gewählt wurde:
     *  Beim Testen der Getter muss lediglich sichergestellt werden, dass der Wert korrekt in das entsprechende
     *  Attribut übertragen wird. Da keine weiteren Berechnungen durchgeführt werden, reicht das überprüfen eines
     *  beliebigen Wertes hier aus.
     */
    @Test
    void testGetA() {
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);
        Triangle t = new Triangle(a, b, c);
        assertEquals(a, t.getA());
    }


  	// Ab hier nur Vorschläge
    //Test for Setter because it's important.

    @Test
    void testSetA() {
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);
        Point2D d = new Point2D(5, 5);
        Triangle t = new Triangle(a, b, c);
        t.setA(d);
        assertEquals(d, t.getA());
    }

    //Trying to check if this point d will really affect or not or java is smarter than me.
    @Test
    void test2SetA(){
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);
        Point2D d = new Point2D(1, 3);
        Triangle t = new Triangle(a, b, c);
        t.setA(d);

        assertEquals(a, t.getA());

    }
     //Testing if Points are working perfectly.
    @Test
    void testGetAB(){
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);

        Triangle t = new Triangle(a, b, c);

        Vector2D d = b.vectorFrom(a);
        assertEquals(d,t.getAB());

    }
//Just a rough check
    @Test
    void test2GetAB(){
        Point2D a = new Point2D(1, 3);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);

        Triangle t = new Triangle(a, b, c);
        Point2D d = new Point2D(5,5);
        t.setA(d);

        Vector2D db =b.vectorFrom(d);
        assertEquals(db,t.getAB());

    }


//Comparing angle A from the triangle program and with  the one I wrote
    @Test
    void testGetAngleAtA(){
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);
        Triangle t = new Triangle(a, b, c);
        Vector2D ab=b.vectorFrom(a);
        Vector2D ac= c.vectorFrom(a);


        double angle = Math.acos(ab.dot(ac) / (ab.length() * ac.length()));
        assertEquals(angle,t.getAngleAtA(),1e-12);

    }
    //Nothing to worry test's passing :) and important to check the validity of the triangle.

    @Test
    void test2GetAngleAtA() {
        Point2D a = new Point2D(1, 3);
        Point2D b = new Point2D(2, 2);
        Point2D c = new Point2D(2, 2);
        Triangle t = new Triangle(a, b, c);
        Vector2D ab = b.vectorFrom(a);
        Vector2D ac = c.vectorFrom(a);


        double angle = Math.acos(ab.dot(ac) / (ab.length() * ac.length()));

        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertEquals(angle, t.getAngleAtA(), 1e-12);


    }


        // ...

//Comparing my value with the initial set up value from program.
    @Test
    void testGetArea() {
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);
        Triangle t = new Triangle(a, b, c);
        Vector2D ab =b.vectorFrom(a);
        Vector2D ac= c.vectorFrom(a);

        double angle = Math.acos(ab.dot(ac) / (ab.length() * ac.length()));
        double base = ac.length();
        double height = ab.length() * Math.sin(angle);
        double area= 0.5*base*height;

        assertEquals(area,t.getArea(),1e-12);


    }
    //Checking validity ,its important
    @Test
    void testUngueltigGetArea() {
        Point2D a = new Point2D(2, 2);
        Point2D b = new Point2D(0, 0);
        Point2D c = new Point2D(2, 2);
        Triangle t = new Triangle(a, b, c);
        Vector2D ab =b.vectorFrom(a);
        Vector2D ac= c.vectorFrom(a);

        double angle = Math.acos(ab.dot(ac) / (ab.length() * ac.length()));
        double base = ac.length();
        double height = ab.length() * Math.sin(angle);
        double area= 0.5*base*height;

        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertEquals(area,t.getArea(),1e-12);


    }
    //Testing if SCALENE .

    @Test
    void TestisScalene(){
        Point2D a = new Point2D(0, 5);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals(Math.abs(ab - ac) > delta && Math.abs(ab - bc) > delta && Math.abs(ac - bc) > delta,t.isScalene());


    }
    //Testing validity of triangle with 2 same coordinates
    @Test
    void TestisInvalidScalene(){
        Point2D a = new Point2D(2, 2);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(2, 2);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertEquals(Math.abs(ab - ac) > delta && Math.abs(ab - bc) > delta && Math.abs(ac - bc) > delta,t.isScalene());


    }
    //Testing validity of traingle with 3 same coordinates
    @Test
    void TestisNotScalene(){
        Point2D a = new Point2D(1, 1);
        Point2D b = new Point2D(1, 1);
        Point2D c = new Point2D(1, 1);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertEquals(Math.abs(ab - ac) > delta && Math.abs(ab - bc) > delta && Math.abs(ac - bc) > delta,t.isScalene());


    }
    //Testing validity if all sides originates from one same points.
    @Test
    void TestisNotScalene2(){
        Point2D a = new Point2D(1, 0);
        Point2D b = new Point2D(1, 1);
        Point2D c = new Point2D(1, 2);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertEquals(Math.abs(ab - ac) > delta && Math.abs(ab - bc) > delta && Math.abs(ac - bc) > delta,t.isScalene());


    }
    //Testing if ISOSCELES.
    @Test
    void TestisIsosceles() {
        Point2D a = new Point2D(2, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 5);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals((Math.abs(ab - ac) < delta) || (Math.abs(ab - bc) < delta) || (Math.abs(ac - bc) < delta), t.isIsosceles());

    }
    //Testing validity of triangle with 2 same coordinates
        @Test
    void TestisInvalidIsosceles(){
        Point2D a = new Point2D(2, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(2, 0);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertEquals((Math.abs(ab - ac) < delta) ||(Math.abs(ab - bc) < delta)||(Math.abs(ac - bc) < delta),t.isIsosceles());

    }
    //Testing validity of triangle with 3 same coordinates
    @Test
    void TestisNotIsosceles(){
        Point2D a = new Point2D(1, 1);
        Point2D b = new Point2D(1, 1);
        Point2D c = new Point2D(1, 1);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;
        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());

        assertEquals((Math.abs(ab - ac) < delta) ||(Math.abs(ab - bc) < delta)||(Math.abs(ac - bc) < delta),t.isIsosceles());

    }
    //Testing validity if all sides originates from one same points.
    @Test
    void TestisNotIsosceles2(){
        Point2D a = new Point2D(1, 0);
        Point2D b = new Point2D(1, 1);
        Point2D c = new Point2D(1, 2);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;
        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());

        assertEquals((Math.abs(ab - ac) < delta) ||(Math.abs(ab - bc) < delta)||(Math.abs(ac - bc) < delta),t.isIsosceles());

    }

    //Testing if EQUILATERAL.
    @Test
    void TestisEquilateral(){
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals((Math.abs(ab - ac) < delta && Math.abs(ab - bc) < delta),t.isEquilateral());

    }
    //Testing validity of traingle with 2 same coordinates
    @Test
    void TestisInvalidEquilateral(){
        Point2D a = new Point2D(2, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(2, 0);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertEquals((Math.abs(ab - ac) < delta && Math.abs(ab - bc) < delta),t.isEquilateral());

    }
    //Testing validity of triangle with 3 same coordinates
    @Test
    void TestisNotEquilateral(){
        Point2D a = new Point2D(1, 1);
        Point2D b = new Point2D(1, 1);
        Point2D c = new Point2D(1, 1);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertEquals((Math.abs(ab - ac) < delta && Math.abs(ab - bc) < delta),t.isEquilateral());

    }
    //Testing validity if all sides originates from one same points.
    @Test
    void TestisNotEquilateral2(){
        Point2D a = new Point2D(1, 0);
        Point2D b = new Point2D(1, 1);
        Point2D c = new Point2D(1, 2);
        Triangle t = new Triangle(a, b, c);

        double ab = b.vectorFrom(a).length();
        double ac = c.vectorFrom(a).length();
        double bc = c.vectorFrom(b).length();
        double delta = 1e-12;

        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertEquals((Math.abs(ab - ac) < delta && Math.abs(ab - bc) < delta),t.isEquilateral());

    }

    //Testing if VALID.

    @Test
    void TestisValidTriangle(){
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);
        Triangle t = new Triangle(a, b, c);
        Vector2D ab =b.vectorFrom(a);
        Vector2D ac= c.vectorFrom(a);
        double delta = 1e-12;

     boolean validTriangle =  ((Math.abs(ab.length()) < delta || (Math.abs(ac.length()) < delta) ||(Math.abs(ab.getY()) < delta && Math.abs(ac.getY()) < delta) ||(Math.abs(ab.getX() / ab.getY() - ac.getX() / ac.getY()) < delta)));
     assertNotEquals(validTriangle,t.isValidTriangle());

    }
    //Testing validity of traingle with 2 same coordinates
    @Test
    void TestisNotValidTriangle() {
        Point2D a = new Point2D(4, 1);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(4, 1);
        Triangle t = new Triangle(a, b, c);
        Vector2D ab = b.vectorFrom(a);
        Vector2D ac = c.vectorFrom(a);
        double delta = 1e-12;

        boolean NotvalidTriangle = ((Math.abs(ab.length()) < delta || (Math.abs(ac.length()) < delta) || (Math.abs(ab.getY()) < delta && Math.abs(ac.getY()) < delta) || (Math.abs(ab.getX() / ab.getY() - ac.getX() / ac.getY()) < delta)));
        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertNotEquals(NotvalidTriangle, t.isValidTriangle());

    }
    //Testing validity of triangle with 3 same coordinates
    @Test
    void TestisNotValidTriangle2() {
        Point2D a = new Point2D(4, 4);
        Point2D b = new Point2D(4, 4);
        Point2D c = new Point2D(4, 4);
        Triangle t = new Triangle(a, b, c);
        Vector2D ab = b.vectorFrom(a);
        Vector2D ac = c.vectorFrom(a);
        double delta = 1e-12;

        boolean NotvalidTriangle = ((Math.abs(ab.length()) < delta || (Math.abs(ac.length()) < delta) || (Math.abs(ab.getY()) < delta && Math.abs(ac.getY()) < delta) || (Math.abs(ab.getX() / ab.getY() - ac.getX() / ac.getY()) < delta)));
        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertNotEquals(NotvalidTriangle, t.isValidTriangle());

    }
    //Testing validity if all sides originates from one same points.
    @Test
    void TestisNotValidTriangle3() {
        Point2D a = new Point2D(4, 1);
        Point2D b = new Point2D(4, 2);
        Point2D c = new Point2D(4, 3);
        Triangle t = new Triangle(a, b, c);
        Vector2D ab = b.vectorFrom(a);
        Vector2D ac = c.vectorFrom(a);
        double delta = 1e-12;

        boolean NotvalidTriangle = ((Math.abs(ab.length()) < delta || (Math.abs(ac.length()) < delta) || (Math.abs(ab.getY()) < delta && Math.abs(ac.getY()) < delta) || (Math.abs(ab.getX() / ab.getY() - ac.getX() / ac.getY()) < delta)));
        assertEquals("Ungültiges Dreieck!",PinguLib.getConsoleOutput());
        assertNotEquals(NotvalidTriangle, t.isValidTriangle());


    }

    @Test
    void TestContructor(){
        Triangle t = new Triangle(new Point2D(0,0),new Point2D(1,1),new Point2D(3,3));
        assertEquals(new Point2D(0,0),t.getA());
    }



}
