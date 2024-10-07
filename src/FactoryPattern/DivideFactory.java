package FactoryPattern;

public class DivideFactory implements CalculatorFactory {
    @Override
    public Calculator createCalculator() {
        return new DivisionCalculator();
    }
}
