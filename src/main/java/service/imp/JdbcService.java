package service.imp;

import entity.User;
import storage.ConfigConnection;
import storage.JdbcMemoryUserStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcService extends ConfigConnection {


    public boolean userRegister(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                String query = "select 1 from `users` where `UserLogin` = ? and `UserPass` = ?";
                String addUser = "INSERT INTO `users` (UserLogin,UserPass) values(?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPass());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return false;
                } else {
                    ps = connection.prepareStatement(addUser);
                    ps.setString(1, user.getLogin());
                    ps.setString(2, user.getPass());
                    ps.execute();
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


//    public boolean register(User user) {
//        if (verificationUserLogin(user)) {
//            User newUser = new User(user.getName(), user.getLogin(), user.getPass());
////            inMemoryStorage.userList.add(newUser);
//            return true;
//        }
//        return false;
//    }

//    public boolean verificationUserLogin(User user) { //в сервисе
//        for (User us : userList) {
//            if (us.getLogin().equals(user.getLogin())) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public User findByUsername(String name) {
//        for (User us : userList) {
//            if (us.getName().equals(name)) {
//                return us;
//            }
//        }
//        return null;
//    }
}
