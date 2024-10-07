package FactoryPattern;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FactoryPatternCalculatorTest {

    @Test
    public void testAddition() {
        CalculatorFactory addFactory = new AddFactory();
        Calculator calculator = addFactory.createCalculator();
        assertEquals(8, calculator.calculate(5, 3));
    }

    @Test
    public void testSubtraction() {
        CalculatorFactory subtractFactory = new SubtractFactory();
        Calculator calculator = subtractFactory.createCalculator();
        assertEquals(2, calculator.calculate(5, 3));
    }

    @Test
    public void testMultiplication() {
        CalculatorFactory multiplyFactory = new MultiplyFactory();
        Calculator calculator = multiplyFactory.createCalculator();
        assertEquals(15, calculator.calculate(5, 3));
    }

    @Test
    public void testDivision() {
        CalculatorFactory divideFactory = new DivideFactory();
        Calculator calculator = divideFactory.createCalculator();
        assertEquals(2, calculator.calculate(6, 3));
    }

    @Test
    public void testDivisionByZero() {
        CalculatorFactory divideFactory = new DivideFactory();
        Calculator calculator = divideFactory.createCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
