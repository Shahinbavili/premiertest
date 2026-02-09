package com.tdd.testing.premiertest;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public void longCalculation() {
        try {
//            Attendre 2 secondes
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Set<Integer> digitsSet(int number) {
        if (number == 0) {
            return Set.of(0);
        }

        Set<Integer> digits = new HashSet<>();
        int abs = Math.abs(number);  // on enlève le signe une bonne fois

        while (abs > 0) {
            digits.add(abs % 10);
            abs /= 10;
        }

        return digits;
    }
}
