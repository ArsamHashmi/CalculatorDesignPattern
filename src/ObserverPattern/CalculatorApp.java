package ObserverPattern;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        System.out.println("Observer Pattern Calculator!");

        Calculator calculator = new Calculator();
        CalculatorDisplay display = new CalculatorDisplay();

        // Register the observer
        calculator.addObserver(display);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter operation (add, subtract, multiply, divide) or 'exit' to quit: ");
            String operation = scanner.nextLine();

            // Exit condition
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            switch (operation.toLowerCase()) {
                case "add":
                    calculator.add(num1, num2);           // Notifies observers
                    break;
                case "subtract":
                    calculator.subtract(num1, num2);      // Notifies observers
                    break;
                case "multiply":
                    calculator.multiply(num1, num2);      // Notifies observers
                    break;
                case "divide":
                    if (num2 != 0) {
                        calculator.divide(num1, num2);    // Notifies observers
                    } else {
                        System.out.println("Cannot divide by zero.");
                    }
                    break;
                default:
                    System.out.println("Invalid operation. Please try again.");

                System.out.println("Execution complete");
            }
        }

        scanner.close();
        System.out.println("Calculator closed.");
    }
}
