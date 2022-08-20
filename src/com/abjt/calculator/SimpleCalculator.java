package com.abjt.calculator;

import com.abjt.calculator.base.BaseCalculator;
import com.abjt.service.CalculatorService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator extends BaseCalculator {

    private static final int INVALID_INPUT = -1;
    private static final int EXIT = 5;

    private Scanner scanner;
    private int userInput = INVALID_INPUT;
    private Operator operator;

    public SimpleCalculator(CalculatorService calculatorService) {
        super(calculatorService);
    }

    public void startCalculator() {
        initScanner();
        for (; ; ) {
            showCalculatorOptions();
            validateUserOption();
            if (isOptionExit()) return;
            initialiseOperator();
            performCalculation(operator);
        }
    }

    private void initScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    private void showCalculatorOptions() {
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("Choose your option: \nEnter 1 for Addition\nEnter 2 for Subtraction\nEnter 3 for Multiplication\nEnter 4 for Division\nEnter 5 for Exit.");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.print("Option : ");
    }

    private void validateUserOption() {
        try {
            userInput = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            throw new InputMismatchException("Please enter an Integer option of 1 or 2 or 3 or 4");
        }
    }

    private void initialiseOperator() {
        operator = validateOperator(userInput);
        if (operator == null) throw new IllegalArgumentException(INVALID_OPERATOR);
    }

    @Contract(pure = true)
    private @NotNull Boolean isOptionExit() {
        return (userInput == EXIT);
    }

    private void performCalculation(Operator operator) {
        calculate(getFirstNumber(), getSecondNumber(), operator);
    }

    private @NotNull Double getFirstNumber() {
        System.out.print("Enter first number : ");
        return scanner.nextDouble();
    }

    private @NotNull Double getSecondNumber() {
        System.out.print("Enter Second number :");
        return scanner.nextDouble();
    }
}
