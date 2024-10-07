package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<CalculatorObserver> observers = new ArrayList<>();

    // Method to add an observer
    public void addObserver(CalculatorObserver observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void removeObserver(CalculatorObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers about a calculation
    private void notifyObservers(String operation, double result) {
        for (CalculatorObserver observer : observers) {
            observer.notify(operation, result);
        }
    }

    public double add(double a, double b) {
        double result = a + b;
        notifyObservers("Addition", result);
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        notifyObservers("Subtraction", result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        notifyObservers("Multiplication", result);
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = a / b;
        notifyObservers("Division", result);
        return result;
    }
}
