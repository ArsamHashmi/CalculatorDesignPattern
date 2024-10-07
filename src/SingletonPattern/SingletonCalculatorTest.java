package SingletonPattern;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SingletonCalculatorTest {

    @Test
    public void testSingletonInstance() {
        Calculator calculator1 = Calculator.getInstance();
        Calculator calculator2 = Calculator.getInstance();

        // Test that both references point to the same instance
        assertSame(calculator1, calculator2);
    }

    @Test
    public void testAddition() {
        Calculator calculator = Calculator.getInstance();
        double result = calculator.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = Calculator.getInstance();
        double result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = Calculator.getInstance();
        double result = calculator.multiply(5, 3);
        assertEquals(15, result);
    }

    @Test
    public void testDivision() {
        Calculator calculator = Calculator.getInstance();
        double result = calculator.divide(6, 3);
        assertEquals(2, result);
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = Calculator.getInstance();
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}
