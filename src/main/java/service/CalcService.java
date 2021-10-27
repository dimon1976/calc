package service;

import entity.User;

import java.util.ArrayList;

public class CalcService {

    public static double start(Double num1, Double num2, String op, User user) {
        MathService mathematics = new MathService();
        switch (op) {
            case "sum":
                double sum = mathematics.sum(num1, num2);
                checkingHistorySheet(user, sum);
                return sum;
            case "subtrack":
                double sub = mathematics.sub(num1, num2);
                checkingHistorySheet(user, sub);
                return sub;
            case "div":
                double div = mathematics.division(num1, num2);
                checkingHistorySheet(user, div);
                return div;
            case "multiply":
                double multi = mathematics.multi(num1, num2);
                checkingHistorySheet(user, multi);
                return multi;
        }
        return 0;
    }

    private static void checkingHistorySheet(User user, double multi) {
        if (user.getResultList() != null) {
            user.getResultList().add(multi);
        } else {
            user.setResultList(new ArrayList<>());
            user.getResultList().add(multi);
        }
    }
}

