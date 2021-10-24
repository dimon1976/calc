package service.imp;

import entity.User;
import storage.InMemoryStorage;

import java.util.List;

public class UserMemoryService {

    public boolean register(User user) {
        if (verificationUserLogin(user)) {
            User newUser = new User(user.getName(), user.getLogin(), user.getPass());
            InMemoryStorage.addUserList(newUser);
            return true;
        }
        return false;
    }

    public boolean verificationUserLogin(User user) {
        if (!InMemoryStorage.getUserList().isEmpty()) {
            for (User us : InMemoryStorage.getUserList()) {
                if (us.getLogin().equals(user.getLogin())) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public User findByUsername(String name) {
        for (User us : InMemoryStorage.getUserList()) {
            if (us.getName().equals(name)) {
                return us;
            }
        }
        return null;
    }

    public void deleteUser(User user) {
        List<User> userList = InMemoryStorage.getUserList();
        if (userList != null && !userList.isEmpty()) {
            for (User r : userList) {
                if (user.getLogin().equals(r.getLogin())) {
                    userList.remove(user);
                    return;
                }
            }
        }
    }

    public void editUser(User user, String name, String username, String password) {
        List<User> userList = InMemoryStorage.getUserList();
        if (userList != null && !userList.isEmpty()) {
            for (User r : userList) {
                if (user.getLogin().equals(r.getLogin())) {
                    r.setName(name);
                    r.setLogin(username);
                    r.setPass(password);
                    return;
                }
            }
        }


    }
}
