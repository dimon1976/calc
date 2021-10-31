package service;

import entity.History;
import entity.User;
import storage.JdbcHistoryCalculate;

import java.util.ArrayList;

public class CalcService {
    JdbcHistoryCalculate history = new JdbcHistoryCalculate();

    public Double start(Double num1, Double num2, String op, User user) {
        MathService mathematics = new MathService();
        switch (op) {
            case "sum":
                double sum = mathematics.sum(num1, num2);
                history.save(num1, num2, sum, user, "+");
                return sum;
            case "subtrack":
                double sub = mathematics.sub(num1, num2);
                history.save(num1, num2, sub, user, "-");
                return sub;
            case "div":
                double div = mathematics.division(num1, num2);
                history.save(num1, num2, div, user, "/");
                return div;
            case "multiply":
                double multi = mathematics.multi(num1, num2);
                history.save(num1, num2, multi, user, "*");
                return multi;
        }
        return null;
    }

    public ArrayList<History> select(User user) {
        return history.history(user);
    }

//    private static void checkingHistorySheet(User user, double multi) {
//        if (user.getResultList() != null) {
//            user.getResultList().add(multi);
//        } else {
//            user.setResultList(new ArrayList<>());
//            user.getResultList().add(multi);
//        }
//    }
}

