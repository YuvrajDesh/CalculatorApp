package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    CalculatorService service = new CalculatorService();

    @Test
    void testSqrt() {
        assertEquals(2.0, service.sqrt(4), 0.01);
    }

    @Test
    void testFactorial() {
        assertEquals(120, service.factorial(5));
    }

    @Test
    void testLn() {
        assertEquals(1.0, service.ln(Math.E), 0.01);
    }

    @Test
    void testPower() {
        assertEquals(8.0, service.power(2, 3), 0.01);
    }
}

