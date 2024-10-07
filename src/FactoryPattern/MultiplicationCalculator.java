package FactoryPattern;

public class MultiplicationCalculator implements Calculator {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}
