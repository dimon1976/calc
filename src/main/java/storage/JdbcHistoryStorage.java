package storage;

import entity.History;
import entity.User;

import java.sql.*;
import java.util.LinkedList;
import java.time.Instant;


public class JdbcHistoryStorage extends ConfigConnection {
    //    Instant dt = Instant.now();
//    long dt = System.currentTimeMillis();
    private static final String query = "INSERT INTO history_result (UId,num1,num2,result,op) VALUES (?,?,?,?,?)";
    private static final int value1 = 1;
    private static final int value2 = 2;
    private static final int value3 = 3;
    private static final int value4 = 4;
    private static final int value5 = 5;
    private static final int value6 = 6;


    private final static String num1 = "num1";
    private final static String num2 = "num2";
    private final static String result = "result";
    private final static String dateTime = "dt";
    private final static String operation = "op";

    public void save(double num1, double num2, double result, User user, String operation) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(value1, user.getId());
                ps.setDouble(value2, num1);
                ps.setDouble(value3, num2);
                ps.setDouble(value4, result);
//                ps.setLong(value5, dt);
                ps.setString(value5, operation);
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList<History> findAllHistory(int userId) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                LinkedList<History> list = new LinkedList<>();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM history_result WHERE UId = " + userId);
                while (resultSet.next()) {
                    Double number1 = resultSet.getDouble(num1);
                    Double number2 = resultSet.getDouble(num2);
                    Double res = resultSet.getDouble(result);
                    String op = resultSet.getString(operation);
                    Date date1 = resultSet.getDate(dateTime);
                    History historyResult = new History(number1, number2, res, op, date1);
                    list.addFirst(historyResult); //add first position on list
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
