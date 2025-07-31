package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pgdp.searchengine.util.Date;

public class TestDate {

    // ***********************************
    // DO NOT DELETE OR CHANGE THE FOLLOWING LINES
    // ***********************************

    // Damit ihr den Konsolen-Output einfach lesen könnt.
    // Ihr könnt diese Methoden einfach ignorieren.
    @BeforeEach
    void setup() {
        PinguLib.setup();
    }

    @AfterEach
    void reset() {
        PinguLib.reset();
    }
    // ***********************************

    // Fülle jede Test-Methode mit je mindestens 5 Tests für die korrespondierende Date-Methode bzw. die zu testende
    // Funktionalität im Falle von 'testDateConstructor(In)valid()' und 'testMethodCallsOnInvalidDates()'
    // Schreibe wieder über jede Methode einen Kommentar, der die Auswahl der >= 5 Tests erklärt.

    /*  Testen des Konstruktors mit gültigem Datum
     *  Ein Paar verschiedene gültige Daten werden hier abgedeckt, um zu überprüfen, ob wirklich alle gültigen Daten
     *  korrekt behandelt werden. Es muss hier nicht unbedingt so ausführlich getestet werden, wie später 'isValidDate()'.
     *  Ein Paar Randfälle (wie den 29.Februar XYZ) abzudecken, ist aber angeraten, da der Konstruktor 'isValidDate()' falsch
     *  oder gar nicht verwenden könnte.
     */
    @Test
    public void testDateConstructorValid() {
        Date date1 = new Date(12, 11, 2021);
        Date date2 = new Date(29, 2, 2024);
        Date date3 = new Date(29, 2, 2000);
        Date date4 = new Date(24, 12, 0);
        Date date5 = new Date(11, 8, -333);
        // ...
    }

    @Test
    public void testDateConstructorInvalid() {
        Date date = new Date(29, 2, 2021);
        // ...
        assertEquals("???", PinguLib.getConsoleOutput(), "Hier sollte eigentlich ein Fehlertext ausgegeben werden ...");
        // ...
    }

    @Test
    public void testYearsUntil() {

    }

    @Test
    public void testDaysUntil() {

    }

    @Test
    public void testDateMillisecondsAfterNewYear1970() {

    }

    @Test
    public void testDaysLeftThisYear() {

    }

    @Test
    public void testDaysPassedThisYear() {

    }

    @Test
    public void testIsLeapYear() {

    }

    @Test
    public void testDaysInMonth() {

    }

    @Test
    public void testDaysInYear() {

    }

    @Test
    public void testIsValidDate() {

    }

    @Test
    public void testMethodCallsOnInvalidDates() {

    }
}
