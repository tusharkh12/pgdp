package pgdp.encapsulated.point_user;

// TODO Zu 'import pgdp.encapsulated.polar.Point;' ändern, um Update zur neuesten Version der Point-Bibliothek zu simulieren

import pgdp.encapsulated.cartesian.Point;

import java.util.Scanner;

//  Diese Klasse DARF NICHT VERÄNDERT WERDEN! Sie repräsentiert einen Nutzer der Point-Bibliothek
//  und ist für deren Entwickler unzugänglich.

public class PointUser {

    public static void main(String[] args) {
        Point p1 = enterPoint();
        Point p2 = enterPoint();
        displayDistances(p1, p2);

        enterCoordinate(p1, "first", 'x');
        enterCoordinate(p2, "second", 'y');
        displayDistances(p1, p2);
    }

    // Punkt vom Nutzer eingeben lassen
    public static Point enterPoint() {
        Scanner in = new Scanner(System.in);
        boolean correctInputGiven = false;
        double x = 0.0, y = 0.0;
        while (!correctInputGiven) {
            System.out.println("Please enter two coordinates, separated by comma:");
            String s = in.nextLine();
            s = s.replaceAll(" ", "");
            String[] numbers = s.split(",");
            try {
                x = Double.parseDouble(numbers[0]);
                y = Double.parseDouble(numbers[1]);
                correctInputGiven = true;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input format!");
                System.out.println("Please enter a text of the following form: '<Number>, <Number>'\n");
            }
        }
        return new Point(x, y);
    }

    // Koordinate 'coord' des Punktes 'p' vom Nutzer neu setzen lassen
    public static void enterCoordinate(Point p, String ordinalNumber, char coord) {
        Scanner in = new Scanner(System.in);
        boolean correctInputGiven = false;
        double d = 0.0;
        while (!correctInputGiven) {
            System.out.println(
                    "The " + ordinalNumber + " point currently has coordinates [" + p.getX() + ", " + p.getY() + "]. " +
                            "Please enter a new " + coord + "-coordinate.");
            String s = in.nextLine();
            try {
                d = Double.parseDouble(s);
                correctInputGiven = true;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input format!");
                System.out.println("Please enter a number!'\n");
            }
        }
        switch (coord) {
            case 'x' -> p.setX(d);
            case 'y' -> p.setY(d);
            default -> System.out.println("Something went wrong ...   <--- A+ error message!");
        }
    }

    public static void displayDistances(Point p1, Point p2) {
        System.out.println("--------------------------------");

        // Textausgabe zu Distanz zwischen zwei Punkten
        System.out.println("Distance between [" + p1.getX() + ", " + p1.getY() +
                "] and [" + p2.getX() + ", " + p2.getY() + "]:");
        System.out.println(p1.distanceTo(p2));

        System.out.println();

        // Textausgabe zu Distanzen zum Ursprung
        System.out.println("Points [" + p1.getX() + ", " + p1.getY() +
                "] and [" + p2.getX() + ", " + p2.getY() + "] have distances");
        System.out.println("\t" + p1.distanceToOrigin() + " and " +
                p2.distanceToOrigin());
        System.out.println("to the origin.");

        System.out.println("--------------------------------");
    }

}
