package FactoryPattern;

public class AddFactory implements CalculatorFactory {
    @Override
    public Calculator createCalculator() {
        return new AdditionCalculator();
    }
}
