package ObserverPattern;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ObserverCalculatorTest {

    @Test
    public void testObserverNotified() {
        Calculator calculator = new Calculator();
        CalculatorDisplay display = new CalculatorDisplay();

        // Redirect output stream to capture print statements
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Register the observer
        calculator.addObserver(display);

        // Perform a calculation
        calculator.add(5, 3);

        // Check the output
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Operation: Addition, Result: 8"));

        // Reset the output stream
        System.setOut(System.out);
    }

    @Test
    public void testObserverRemoved() {
        Calculator calculator = new Calculator();
        CalculatorDisplay display = new CalculatorDisplay();

        // Redirect output stream to capture print statements
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Register the observer
        calculator.addObserver(display);

        // Remove the observer
        calculator.removeObserver(display);

        // Perform a calculation
        calculator.add(5, 3);

        // Check that the observer was not notified
        String output = outputStream.toString().trim();
        assertFalse(output.contains("Operation: Addition, Result: 8"));

        // Reset the output stream
        System.setOut(System.out);
    }

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.add(5, 3));
        assertEquals(10, calculator.add(7, 3));
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(4, calculator.subtract(7, 3));
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(21, calculator.multiply(7, 3));
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(3, calculator.divide(9, 3));
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
