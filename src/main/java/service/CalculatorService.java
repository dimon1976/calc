package service;

public class CalculatorService {

    public static double start(Double num1, Double num2, String op) {
        Mathematics mathematic = new Mathematics();
        switch (op) {
            case "sum":
                return mathematic.sum(num1, num2);
            case "sub":
                return mathematic.sub(num1, num2);
            case "delete":
                return mathematic.delete(num1, num2);
            case "multi":
                return mathematic.multi(num1, num2);
        }
        return 0;
    }
}

