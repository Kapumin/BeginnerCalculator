package com.abjt.main;

import com.abjt.calculator.SimpleCalculator;
import com.abjt.service.CalculatorService;

public class CalculatorInitiator {

    public static void main(String[] args) {
        SimpleCalculator simpleCalculator = new SimpleCalculator(CalculatorService.getCalculatorService());
        simpleCalculator.startCalculator();
    }
}
