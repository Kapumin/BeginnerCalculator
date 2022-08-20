package com.abjt.calculator;

import com.abjt.interfaces.Calculator;
import com.abjt.models.Operators;

public class BaseCalculator {

    public static Operators validateOperator(int userOption) {
        return switch (userOption) {
            case 1 -> Operators.ADDITION;
            case 2 -> Operators.SUBTRACTION;
            case 3 -> Operators.MULTIPLICATION;
            case 4 -> Operators.DIVISION;
            default -> null;
        };
    }

    public static void calculate(double num1, double num2, Calculator calculator, Operators operator) {
        switch (operator) {
            case ADDITION -> System.out.println("The sum is : " + calculator.add(num1, num2));
            case SUBTRACTION -> System.out.println("The difference is : " + calculator.subtract(num1, num2));
            case MULTIPLICATION -> System.out.println("The product is : " + calculator.multiply(num1, num2));
            case DIVISION -> System.out.println("The quotient is : " + calculator.divide(num1, num2));
            default -> System.out.println("Invalid input.");
        }
    }
}
