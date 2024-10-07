package StrategyPattern;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import StrategyPattern.*;

class StrategyPatternCalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        calculator.setStrategy(new AddStrategy());
        assertEquals(15, calculator.calculate(10, 5), 0.001);
    }

    @Test
    public void testSubtraction() {
        calculator.setStrategy(new SubtractStrategy());
        assertEquals(5, calculator.calculate(10, 5), 0.001);
    }

    @Test
    public void testMultiplication() {
        calculator.setStrategy(new MultiplyStrategy());
        assertEquals(50, calculator.calculate(10, 5), 0.001);
    }

    @Test
    public void testDivision() {
        calculator.setStrategy(new DivideStrategy());
        assertEquals(2, calculator.calculate(10, 5), 0.001);
    }

    @Test
    public void testDivisionByZero() {
        calculator.setStrategy(new DivideStrategy());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

}
