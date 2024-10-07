package FactoryPattern;

public class DivisionCalculator implements Calculator {
    @Override
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
