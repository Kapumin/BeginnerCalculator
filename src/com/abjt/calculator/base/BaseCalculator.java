package com.abjt.calculator.base;

import com.abjt.calculator.Operator;
import com.abjt.calculator.interfaces.Calculator;
import com.abjt.service.CalculatorService;

public class BaseCalculator {

    private final Calculator calculator;

    public final String INVALID_OPERATOR = "Invalid Operator";

    public BaseCalculator(CalculatorService calculatorService) {
        calculator = calculatorService.getCalculator();
    }

    public Operator validateOperator(int userOption) {
        return switch (userOption) {
            case 1 -> Operator.ADDITION;
            case 2 -> Operator.SUBTRACTION;
            case 3 -> Operator.MULTIPLICATION;
            case 4 -> Operator.DIVISION;
            default -> null;
        };
    }

    public void calculate(double num1, double num2, Operator operator) {
        switch (operator) {
            case ADDITION -> showResult("The sum is : " + calculator.add(num1, num2).toString());
            case SUBTRACTION -> showResult("The difference is : " + calculator.subtract(num1, num2));
            case MULTIPLICATION -> showResult("The product is : " + calculator.multiply(num1, num2));
            case DIVISION -> showResult("The quotient is : " + calculator.divide(num1, num2));
            default -> showResult(INVALID_OPERATOR);
        }
    }

    private void showResult(String result) {
        System.out.println(result);
    }
}
