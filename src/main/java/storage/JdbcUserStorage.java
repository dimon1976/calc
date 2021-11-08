package storage;
// только хранение

import entity.User;
import storage.imp.UserStorage;

import java.sql.*;
import java.util.LinkedList;


public class JdbcUserStorage extends ConfigConnection implements UserStorage {
    private final static String addUser = "INSERT INTO users (UserName,UserPass,Name,Admin) VALUES (?,?,?,?)";
    private final static String queryLogin = "SELECT UserName FROM users WHERE BINARY UserName = ?";
    private final static String queryUser = "SELECT * FROM users WHERE UserName = ?";
    private final static String queryNotNullUser = "SELECT * FROM users";
    private final static String queryUserName = "SELECT Name FROM users WHERE UserName = ?";
    private final static String queryUserId = "DELETE FROM USERS WHERE UserId = ";
    private final static String updateUser = "UPDATE users SET Name = ?,UserName = ?,UserPass = ? WHERE UserId = ";
    private final static String updateUserRole = "UPDATE users SET Admin = ? WHERE UserId = ";
    private final static String findAllUsers = "SELECT * FROM users";
    private final static int value1 = 1;
    private final static int value2 = 2;
    private final static int value3 = 3;
    private final static int value4 = 4;
    private final static String id = "UserId";
    private final static String userName = "UserName";
    private final static String userPass = "UserPass";
    private final static String name = "Name";
    private final static String admin = "Admin";

    @Override
    public boolean save(User user) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                PreparedStatement ps = connection.prepareStatement(addUser);
                ps.setString(value1, user.getLogin());
                ps.setString(value2, user.getPass());
                ps.setString(value3, user.getName());
                ps.setInt(value4, 0);
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
                PreparedStatement ps = connection.prepareStatement(queryLogin);
                ps.setString(value1, name);
                ResultSet rs = ps.executeQuery();
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public User returnUser(String name) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                PreparedStatement ps = connection.prepareStatement(queryUser);
                ps.setString(value1, name);
                return getUser(ps);
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
                PreparedStatement ps = connection.prepareStatement(queryUserName);
                ps.setString(value1, name);
                return getStringLogin(ps);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void delete(int userId) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                PreparedStatement preparedStatement = connection.prepareStatement(queryUserId + userId);
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
                PreparedStatement preparedStatement = connection.prepareStatement(updateUser + user.getId());
                preparedStatement.setString(value1, name);
                preparedStatement.setString(value2, username);
                preparedStatement.setString(value3, password);
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editRole(int userid, int admin) {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                PreparedStatement preparedStatement = connection.prepareStatement(updateUserRole + userid);
                preparedStatement.setInt(value1, admin);
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private User getUser(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("UserId");
            String userName2 = rs.getString("UserName");
            String userPass = rs.getString("UserPass");
            String name1 = rs.getString("Name");
            int admin = rs.getInt("Admin");
            return (new User(id, name1, userName2, userPass, admin));
        } else {
            return null;
        }
    }

    private String getStringLogin(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("Name");
        } else {
            return null;
        }
    }

    public boolean queryIsFirstUser() {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                PreparedStatement ps = connection.prepareStatement(queryNotNullUser);
                ResultSet rs = ps.executeQuery();
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public LinkedList<User> findAllUser() {
        try {
            try (Connection connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
                LinkedList<User> list = new LinkedList<>();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(findAllUsers);
                while (resultSet.next()) {
                    int usId = resultSet.getInt(id);
                    String usLogin = resultSet.getString(userName);
                    String usPass = resultSet.getString(userPass);
                    String nm = resultSet.getString(name);
                    int adm = resultSet.getInt(admin);
                    User User = new User(usId,nm,usLogin,usPass,adm);
                    list.addFirst(User); //add first position on list
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

