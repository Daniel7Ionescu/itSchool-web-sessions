package com.dan.restone.practice.jpa_hibernate.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }


    @Test
    void testAdd_ShouldPass_WithValidInput(){
        //Given
        int a = 3;
        int b = 2;
        int expectedResult = a + b;

        //When
        int result = calculator.add(a, b);

        //Then
        assertEquals(expectedResult, result, "The addition result should be equal to the expected result.");
    }

    @Test
    void testAdd_ShouldFail_WithResultExceedingIntegerMaxValue(){
        //Given
        int a = Integer.MAX_VALUE;
        int b = 2;
        long expectedResult =(long) a + b;

        //When
        int result = calculator.add(a, b);

        //Then
        assertNotEquals(expectedResult, result);
    }

    @Test
    void testSubtract_ShouldPass_WithValidInput(){
        int a = 3;
        int b = 2;
        int expectedResult = a - b;

        int result = calculator.subtract(a, b);

        assertEquals(expectedResult, result);
    }
}