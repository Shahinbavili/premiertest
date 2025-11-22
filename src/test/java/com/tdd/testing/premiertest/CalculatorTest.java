package com.tdd.testing.premiertest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;
        Calculator calculator = new Calculator();

        // Act
        int somme = calculator.add(a, b);

        // Assert
        assertEquals(5, somme);
    }

    @Test
    void testMultiplyTwoPositiveNumbers() {
        //Arrange
        int a = 3;
        int b = 5;
        Calculator calculator = new Calculator();

        //Act
        int somme = calculator.multiply(a, b);

        //Assert
        assertEquals(15, somme);
    }

}