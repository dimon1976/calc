package service;

import entity.History;
import entity.User;
import storage.JdbcUserStorage;

import java.util.Iterator;
import java.util.LinkedList;

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
    public void useAdminMenu(String op, String userId) {
        int id = Integer.parseInt(userId);
        switch (op) {
            case "del":
                jdbcStorage.delete(id);
                break;
            case "adminon":
                jdbcStorage.editRole(id, 1);
                break;
            case "adminoff":
                jdbcStorage.editRole(id, 0);
                break;
            case "history_operation":
                break;
            case "edit":
                break;
            default:
                break;
        }
    }

    public boolean registerUserJdbc(User user) {
        boolean isEmpty = jdbcStorage.queryIsFirstUser();
        if (isEmpty) {
            boolean existLogin = jdbcStorage.verificationLogin(user.getLogin());
            if (existLogin) {
                return false;
            }
            jdbcStorage.save(user);
            return true;
        }
        saveAdmin(user);
        return true;
    }

    private void saveAdmin(User user) {
        jdbcStorage.save(user);
        user = jdbcStorage.returnUser(user.getLogin());
        jdbcStorage.editRole(user.getId(), 1);
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

    public boolean checkAdmin(User user) {
        return user.getAdmin() == 1;
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
        jdbcStorage.delete(user.getId());
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

    public LinkedList<User> findAllUsersJdbc() {
        return jdbcStorage.findAllUser();
    }


}
