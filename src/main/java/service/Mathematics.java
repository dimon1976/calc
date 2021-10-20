package service;

import service.imp.CalculatorImp;

public class Mathematics implements CalculatorImp {

    public double sum(double a, double b) {
        return a + b;
    }

    public double delete(double a, double b) {
        return a / b;
    }

    public double multi(double a, double b) {
        return a * b;
    }

    public double sub(double a, double b) {
        return a - b;
    }
}
