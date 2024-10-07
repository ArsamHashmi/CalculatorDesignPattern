package FactoryPattern;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the operation
        System.out.println("Select an operation: add, subtract, multiply, divide");
        String operation = scanner.nextLine().toLowerCase();

        // Initialize the calculator factory based on user input
        CalculatorFactory factory;
        switch (operation) {
            case "add":
                factory = new AddFactory();
                break;
            case "subtract":
                factory = new SubtractFactory();
                break;
            case "multiply":
                factory = new MultiplyFactory();
                break;
            case "divide":
                factory = new DivideFactory();
                break;
            default:
                System.out.println("Invalid operation selected.");
                return;
        }

        // Create the calculator using the factory
        Calculator calculator = factory.createCalculator();

        // Get user input for calculation
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Perform the calculation and display the result
        try {
            double result = calculator.calculate(num1, num2);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
