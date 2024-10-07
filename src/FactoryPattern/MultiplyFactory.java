package FactoryPattern;

public class MultiplyFactory implements CalculatorFactory {
    @Override
    public Calculator createCalculator() {
        return new MultiplicationCalculator();
    }
}
