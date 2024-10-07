package FactoryPattern;

public class SubtractionCalculator implements Calculator {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}
