package StrategyPattern;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.println("Enter second number: ");
            double num2 = scanner.nextDouble();

            System.out.println("Choose operation: +, -, *, /");
            String operation = scanner.next();

            switch (operation) {
                case "+":
                    calculator.setStrategy(new AddStrategy());
                    System.out.println("Result: " + calculator.calculate(num1, num2));
                    break;
                case "-":
                    calculator.setStrategy(new SubtractStrategy());
                    System.out.println("Result: " + calculator.calculate(num1, num2));
                    break;
                case "*":
                    calculator.setStrategy(new MultiplyStrategy());
                    System.out.println("Result: " + calculator.calculate(num1, num2));
                    break;
                case "/":
                    if (num2 != 0) {
                        calculator.setStrategy(new DivideStrategy());
                        System.out.println("Result: " + calculator.calculate(num1, num2));
                    } else {
                        System.out.println("Error: Cannot divide by zero.");
                    }
                    break;
                default:
                    System.out.println("Invalid operation. Please choose +, -, *, or /.");
                    break;
            }

            System.out.println("Do you want to perform another calculation? (yes/no)");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("yes")) {
                continueCalculation = false;
            }
        }

        System.out.println("Calculator closed.");
        scanner.close();
    }
}
