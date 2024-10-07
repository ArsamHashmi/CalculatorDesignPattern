package FactoryPattern;

public class AdditionCalculator implements Calculator {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}

