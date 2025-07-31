package pgdp.thread;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimzahlTestTest {
    @BeforeEach
    public void setImplementation() {
        // Your tests should accept this implementation
        PrimzahlTest.testFunc = x -> {
            if (x <= 0)
                return -1;
            for (int t = 2; t < t * t && t * t <= x; t++)
                if (x % t == 0)
                    return 0;
            return x > 1 ? 1 : 0;
        };
    }

    @Test
    public void testIsPrime1() {
        assertEquals(0, PrimzahlTest.isPrime(1));
    }


    @Test
    public void testIsPrime2() {
        assertEquals(1, PrimzahlTest.isPrime(2));
    }


    @Test
    public void testIsPrime3() {
        assertEquals(1, PrimzahlTest.isPrime(3));
    }


    @Test
    public void testIsPrime29() {
        assertEquals(1, PrimzahlTest.isPrime(29));
    }

    @Test
    public void testIsPrime30() {
        assertEquals(0, PrimzahlTest.isPrime(30));
    }


    @Test
    public void testIsPrime32999() {
        assertEquals(1, PrimzahlTest.isPrime(32999));
    }


    @Test
    public void testIsPrime85227() {
        assertEquals(0, PrimzahlTest.isPrime(85227));
    }


    @Test
    public void testIsPrimeMax() {
        assertEquals(1, PrimzahlTest.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testIsPrimeMaxNeg() {
        assertEquals(0, PrimzahlTest.isPrime(Integer.MAX_VALUE - 1));
    }


    @Test
    public void testIsPrime0() {
        assertEquals(-1, PrimzahlTest.isPrime(0));
    }

    @Test
    public void testIsPrimeMinus1() {
        assertEquals(-1, PrimzahlTest.isPrime(-1));
    }


    @Test
    public void testIsPrimeMinValue() {
        assertEquals(-1, PrimzahlTest.isPrime(Integer.MIN_VALUE));
    }
}

