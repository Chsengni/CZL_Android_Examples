package com.ch.a241_example_01;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void add() {
        int addResult = calculator.add(2,1);
        assertEquals(3,addResult);
    }

    @Test
    public void subtract() {
        int subResult = calculator.subtract(2,1);
        assertEquals(1,subResult);
    }
}