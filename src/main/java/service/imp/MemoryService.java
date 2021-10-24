package service.imp;

import entity.User;
import storage.InMemoryStorage;

public class MemoryService {

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
}
