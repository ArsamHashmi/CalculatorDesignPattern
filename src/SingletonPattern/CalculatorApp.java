package SingletonPattern;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
         System.out.println("Singleton Pattern Calculator!");

        // Get the single instance of Calculator
        Calculator calculator = Calculator.getInstance();

        Scanner scanner = new Scanner(System.in);
        String operation;
        double num1, num2;

        // Loop for user input
        while (true) {
            System.out.print("Enter first number (or type 'exit' to quit): ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("exit")) {
                break; // Exit the loop if the user types 'exit'
            }
            try {
                num1 = Double.parseDouble(input1);

                System.out.print("Enter second number: ");
                num2 = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter operation (add, subtract, multiply, divide): ");
                operation = scanner.nextLine();

                switch (operation.toLowerCase()) {
                    case "add":
                        System.out.println("Addition: " + calculator.add(num1, num2));
                        break;
                    case "subtract":
                        System.out.println("Subtraction: " + calculator.subtract(num1, num2));
                        break;
                    case "multiply":
                        System.out.println("Multiplication: " + calculator.multiply(num1, num2));
                        break;
                    case "divide":
                        if (num2 == 0) {
                            throw new IllegalArgumentException("Cannot divide by zero");
                        }
                        System.out.println("Division: " + calculator.divide(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation! Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format! Please enter numeric values.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close(); // Close the scanner to prevent resource leak
        System.out.println("Calculator exited.");

    }
}
