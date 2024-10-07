package FactoryPattern;

public class SubtractFactory implements CalculatorFactory {
    @Override
    public Calculator createCalculator() {
        return new SubtractionCalculator();
    }
}
