package storage;
// только хранение

import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcMemoryUserStorage extends ConfigConnection {
//    private final JdbcMemoryUserStorage inMemoryStorage = new JdbcMemoryUserStorage();

    public boolean userRegister(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "SELECT 1 FROM `users` WHERE `UserLogin` = ? AND `UserPass` = ? AND 'Username' = ?";
                String addUser = "INSERT INTO `users` (UserLogin,UserPass,UserName) VALUES (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPass());
                ps.setString(3, user.getName());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return false;
                } else {
                    ps = connection.prepareStatement(addUser);
                    ps.setString(1, user.getLogin());
                    ps.setString(2, user.getPass());
                    ps.setString(3, user.getName());
                    ps.execute();
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}

