package service;

import storage.InMemoryStorage;

public class CalculatorService {

    public static double start(Double num1, Double num2, String op) {
        Mathematics mathematics = new Mathematics();
        switch (op) {
            case "sum":
                double sum = mathematics.sum(num1, num2);
                InMemoryStorage.addResult(sum);
                return sum;
            case "sub":
                double sub = mathematics.sub (num1, num2);
                InMemoryStorage.addResult(sub);
                return sub;
            case "div":
                double div = mathematics.delete(num1, num2);
                InMemoryStorage.addResult(div);
                return div;
            case "multi":
                double multi = mathematics.multi(num1, num2);
                InMemoryStorage.addResult(multi);
                return multi;
        }
        return 0;
    }
}

