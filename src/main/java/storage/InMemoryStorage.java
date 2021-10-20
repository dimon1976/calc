package storage;

import user.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private final static List<User> userList = new ArrayList<>();

    public void register(User user) {
        if (verificationUserLogin(user)) {
            User newUser = new User(user.getName(), user.getLogin(), user.getPass());
            userList.add(newUser);
        }
    }


    public static boolean signIn(String name, String login, String pass) {
        for (User datum : userList) {
            if (datum == null) {
                return false;
            } else {
                if (datum.getLogin().equals(login) & datum.getPass().equals(pass)) {
                    return true;
                }
            }
        }
        return false; // конец блока авторизации
    }

    public boolean verificationUserLogin(User user) {
        for (User us : userList) {
            if (us.getLogin().equals(user.getLogin())) {
                System.out.println("This login exists");
                return false;
            }
        }
        return true;
    }


    public void print() {
        for (User us : userList) {
            System.out.println(us.getLogin());
        }
    }
}

