package com.massari.restspringboot.math;

public class MathLogic {
    public static Double sum(Double numberOne, Double numberTwo ) {
        return numberOne + numberTwo;
    }

    public static Double sub(Double numberOne, Double numberTwo ) {
        return numberOne - numberTwo;
    }

    public static Double multiply(Double numberOne, Double numberTwo ) {
        return numberOne * numberTwo;
    }

    public static Double divide(Double numberOne, Double numberTwo ) {
        return numberOne/numberTwo;
    }

    public static Double mean(Double numberOne, Double numberTwo ) {
        return (numberOne + numberTwo) / 2;
    }

    public static Double squarer(Double number ) {
        return Math.sqrt(number);
    }
}
