package service;

import entity.History;
import entity.User;
import storage.JdbcHistoryStorage;

import java.util.LinkedList;

import static service.MathService.*;

public class CalcService {
    JdbcHistoryStorage history = new JdbcHistoryStorage();

    public Double start(Double num1, Double num2, String op, User user) {
        switch (op) {
            case "sum":
                double sum = sum(num1, num2);
                history.save(num1, num2, sum, user, "+");
                return sum;
            case "subtrack":
                double sub = sub(num1, num2);
                history.save(num1, num2, sub, user, "-");
                return sub;
            case "div":
                double div = division(num1, num2);
                history.save(num1, num2, div, user, "/");
                return div;
            case "multiply":
                double multi = multi(num1, num2);
                history.save(num1, num2, multi, user, "*");
                return multi;
        }
        return null;
    }

    public LinkedList<History> select(int userid) {
        return history.returnHistoryOfOperation(userid);
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

