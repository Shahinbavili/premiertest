package com.tdd.testing.premiertest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private static Instant startedAt;
    private Calculator calculatorUnderTest;

    @BeforeEach
    public void initCalculator() {
        System.out.println("Appel avant chaque test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void undefineCalculator() {
        System.out.println("Appel après chaque test");
        calculatorUnderTest = null;
    }

    @BeforeAll
    public static void initStartingTime() {
        System.out.println("Appel avant tous les test");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration() {
        System.out.println("Appel après tous les test");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = {1, 2, 42, 1011, 5089})
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
//        Arrange — tout est prêt !

//        Act -- Multiplier par zéro
        int actualResult = calculatorUnderTest.multiply(0, arg);

//        Assert — ça vaut toujours zéro
        assertThat(actualResult).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0} + {1} should equal to {2}")
    @CsvSource({"1,1,2", "2,3,5", "42,57,99"})
    public void add_should_return_the_sum_of_multiple_Integers(int arg1, int arg2, int expectedResult) {
//        Arrange -- All is ready

//        Act
        int actualResult = calculatorUnderTest.add(arg1, arg2);

//        Assert
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Timeout(1)
    @Test
    public void longCalcule_should_compute_in_less_than_1_second() {
//        Arrange

//        Act
        calculatorUnderTest.longCalculation();

//    Assert
//    ...

    }

    @Test
    void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int somme = calculatorUnderTest.add(a, b);

        // Assert
        assertThat(somme).isEqualTo(5);
    }

    @Test
    void testMultiplyTwoPositiveNumbers() {
        //Arrange
        int a = 3;
        int b = 5;

        //Act
        int product = calculatorUnderTest.multiply(a, b);

        //Assert
        assertThat(product).isEqualTo(15);
    }
}