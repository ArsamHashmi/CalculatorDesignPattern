package ObserverPattern;

public class CalculatorDisplay implements CalculatorObserver {
    @Override
    public void notify(String operation, double result) {
        System.out.println("Operation: " + operation + ", Result: " + result);
    }
}
