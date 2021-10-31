package service;

import entity.User;
import storage.JdbcUserStorage;
import storage.MemoryUserStorage;

import java.util.List;

public class UserService {
    JdbcUserStorage jdbcStorage = new JdbcUserStorage();

//    public boolean register(User user) {
//        if (verificationUserLogin(user)) {
//            User newUser = new User(user.getId(), user.getName(), user.getLogin(), user.getPass());
//            MemoryUserStorage.addUserList(newUser);
//            return true;
//        }
//        return false;
//    }

    public boolean registerUserJdbc(User user) {
        if (!jdbcStorage.verificationLogin(user.getLogin())) {
            jdbcStorage.save(user);
            return true;
        }
        return false;
    }

//    public boolean verificationUserLogin(User user) {
//        if (!MemoryUserStorage.getUserList().isEmpty()) {
//            for (User us : MemoryUserStorage.getUserList()) {
//                if (us.getLogin().equals(user.getLogin())) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return true;
//    }


//    public User findByUsername(String name) {
//        for (User us : MemoryUserStorage.getUserList()) {
//            if (us.getName().equals(name)) {
//                return us;
//            }
//        }
//        return null;
//    }

    public User findByUsernameJdbc(String userName) {
        if (jdbcStorage.verificationLogin(userName)) {
            return jdbcStorage.returnUser(userName);
        }
        return null;
    }

//    public void deleteUser(User user) {
//        List<User> userList = MemoryUserStorage.getUserList();
//        if (userList != null && !userList.isEmpty()) {
//            for (User r : userList) {
//                if (user.getLogin().equals(r.getLogin())) {
//                    userList.remove(user);
//                    return;
//                }
//            }
//        }
//    }

    public void deleteUserJdbc(User user) {
        jdbcStorage.delete(user);
    }

//    public void editUser(User user, String name, String username, String password) {
//        List<User> userList = MemoryUserStorage.getUserList();
//        if (userList != null && !userList.isEmpty()) {
//            for (User r : userList) {
//                if (user.getLogin().equals(r.getLogin())) {
//                    r.setName(name);
//                    r.setLogin(username);
//                    r.setPass(password);
//                    return;
//                }
//            }
//        }
//    }

    public void editUserJdbc(User user, String name, String username, String password) {
        jdbcStorage.edit(user, name, username, password);
    }
}
