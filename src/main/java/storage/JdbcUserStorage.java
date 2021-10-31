package storage;
// только хранение

import entity.User;
import storage.imp.StorageInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcUserStorage extends ConfigConnection implements StorageInterface {
//    private final static String dbNameUser = "users";
//    private final static String dbNameMarksUser = "history_result";
//    private final static int userId = 1;
//    private final static int userName = 2;
//    private final static int userPass = 3;
//    private final static int name = 4;

    @Override
    public boolean save(User user) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String addUser = "INSERT INTO `users` (UserName,UserPass,Name) VALUES (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(addUser);
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPass());
                ps.setString(3, user.getName());
                return ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean verificationLogin(String name) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "SELECT UserName FROM users WHERE UserName = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public User returnUser(String name) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "SELECT * FROM users WHERE UserName = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("UserId");
                    String userName2 = rs.getString("UserName");
                    String userPass = rs.getString("UserPass");
                    String name1 = rs.getString("Name");
                    return (new User(id, name1, userName2, userPass));
                } else {
                    return null;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String findByUsername(String name) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "select Name from users where UserName = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println(rs.getString("Name"));
                    return rs.getString("Name");
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(User user) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "DELETE FROM USERS WHERE UserId = " + user.getId();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(User user, String name, String username, String password) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String update = "UPDATE users SET Name = ?,UserName = ?,UserPass = ? where UserId = " + user.getId();
                PreparedStatement preparedStatement = connection.prepareStatement(update);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

