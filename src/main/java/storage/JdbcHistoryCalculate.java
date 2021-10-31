package storage;

import entity.History;
import entity.User;

import java.sql.*;
import java.util.ArrayList;


public class JdbcHistoryCalculate extends ConfigConnection {
    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

    private final static String num1 = "num1";
    private final static String num2 = "num2";
    private final static String result = "result";
    private final static String dateTime = "dt";
    private final static String operation = "op";

    public void save(double num1, double num2, double result, User user, String operation) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "INSERT INTO history_result (UId,num1,num2,result,dt,op) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, user.getId());
                ps.setDouble(2, num1);
                ps.setDouble(3, num2);
                ps.setDouble(4, result);
                ps.setDate(5, date);
                ps.setString(6, operation);
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<History> history(User user) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                ArrayList<History> list = new ArrayList<>();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM history_result WHERE UId = " + user.getId());
                while (resultSet.next()) {
                    Double number1 = resultSet.getDouble(num1);
                    Double number2 = resultSet.getDouble(num2);
                    Double res = resultSet.getDouble(result);
                    String op = resultSet.getString(operation);
                    Date date1 = resultSet.getDate(dateTime);
                    History historyResult = new History(number1, number2, res, op, date1);
                    list.add(historyResult);
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
