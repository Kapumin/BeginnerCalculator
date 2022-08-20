package com.abjt.calculator;

import com.abjt.interfaces.Calculator;
import com.abjt.service.CalculatorService;
import com.abjt.models.Operators;

import java.util.Scanner;

public class SimpleCalculator extends BaseCalculator {

    private static Scanner scanner;

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
        Calculator calculator = CalculatorService.getCalculator(calculatorService);

        for (; ; ) {
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("Choose your option: \n1 for Addition\n2 for Subtraction\n3 for Multiplication\n4 for Division\n5 for Exit.");
            System.out.println("---------------------------------------------------------------------------------------------------------");

            int userInput = scanner.nextInt();

            if (userInput == 5) return;

            operator = validateOperator(userInput);

            if (operator != null) {
                System.out.print("Enter first number : ");
                firstNumber = scanner.nextDouble();

                System.out.print("Enter Second number :");
                secondNumber = scanner.nextDouble();
                calculate(firstNumber, secondNumber, calculator, operator);
            } else {
               return;
            }
        }
    }
}
