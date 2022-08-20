package com.abjt.service;

import com.abjt.calculator.interfaces.Calculator;

public class CalculatorService implements Calculator {

    private static CalculatorService calculatorService = null;

    private  Calculator calculator = null;

    public static synchronized CalculatorService getCalculatorService() {
        if (calculatorService == null) {
            calculatorService = new CalculatorService();
        }
        return calculatorService;
    }

    @Override
    public Calculator getCalculator() {
        if (calculator == null){
            calculator = calculatorService;
        }
        return calculator;
    }

    @Override
    public Double add(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double subtract(Double x, Double y) {
        return x - y;
    }

    @Override
    public Double multiply(Double x, Double y) {
        return x * y;
    }

    @Override
    public Double divide(Double x, Double y) {
        try {
            return x / y;
        } catch (Exception e) {
            e.getCause();
            return null;
        }
    }
}
