package com.abjt;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static Calculator calculator;

    public static void main(String[] args) {
        initScanner();
        startCalculator();
    }

    private static void initScanner() {
        scanner = new Scanner(System.in);
    }

    private static void startCalculator() {
        Operators operator;
        double firstNumber, secondNumber;
        CalculatorService calculatorService = CalculatorService.getCalculatorService();
        calculator = CalculatorService.getCalculator(calculatorService);

        for (; ; ) {
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("Choose your option: \n1 for Addition\n2 for Subtraction\n3 for Multiplication\n4 for Division\n5 for Exit.");
            System.out.println("---------------------------------------------------------------------------------------------------------");

            int userInput = scanner.nextInt();

            if (userInput == 5) return;

            operator = getOperator(userInput);

            if (operator != null) {
                System.out.print("Enter first number : ");
                firstNumber = scanner.nextDouble();

                System.out.print("Enter Second number :");
                secondNumber = scanner.nextDouble();
                calculate(firstNumber, secondNumber, operator);
            } else {
               return;
            }
        }
    }

    private static Operators getOperator(int userOption) {
        return switch (userOption) {
            case 1 -> Operators.ADDITION;
            case 2 -> Operators.SUBTRACTION;
            case 3 -> Operators.MULTIPLICATION;
            case 4 -> Operators.DIVISION;
            default -> null;
        };
    }

    private static void calculate(double num1, double num2, Operators operator) {
        switch (operator) {
            case ADDITION -> System.out.println("The sum is : " + calculator.add(num1, num2));
            case SUBTRACTION -> System.out.println("The difference is : " + calculator.subtract(num1, num2));
            case MULTIPLICATION -> System.out.println("The product is : " + calculator.multiply(num1, num2));
            case DIVISION -> System.out.println("The quotient is : " + calculator.divide(num1, num2));
            default -> System.out.println("Invalid input.");
        }
    }
}
