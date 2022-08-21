package com.abjt.calculator.base;

import com.abjt.calculator.Operator;
import com.abjt.service.CalculatorService;
import org.jetbrains.annotations.NotNull;

public class BaseCalculator {

    private final CalculatorService calculatorService;

    public final String INVALID_OPERATOR = "Invalid Operator";

    public BaseCalculator(@NotNull CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
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

    public void calculate(double num1, double num2, @NotNull Operator operator) {
        switch (operator) {
            case ADDITION -> showResult("The sum is : " + calculatorService.add(num1, num2).toString());
            case SUBTRACTION -> showResult("The difference is : " + calculatorService.subtract(num1, num2));
            case MULTIPLICATION -> showResult("The product is : " + calculatorService.multiply(num1, num2));
            case DIVISION -> showResult("The quotient is : " + calculatorService.divide(num1, num2));
            default -> showResult(INVALID_OPERATOR);
        }
    }

    private void showResult(String result) {
        System.out.println(result);
    }
}
