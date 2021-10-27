package storage;
// только хранение

import entity.User;
import storage.imp.StorageInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcUserStorage extends ConfigConnection implements StorageInterface {

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
    public boolean verificationLogin(String userName) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "SELECT UserName FROM users WHERE UserName = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, userName);
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

    public User returnUser(String userName) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "SELECT * FROM users WHERE UserName = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, userName);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String userName2 = rs.getString("UserName");
                    String userPass = rs.getString("UserPass");
                    String name = rs.getString("Name");
                    return (new User(name, userName2, userPass));
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
    public String findByUsername(String userName) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "select Name from users where UserName = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, userName);
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

    }

    @Override
    public void edit(User user, String name, String username, String password) {

    }


}

