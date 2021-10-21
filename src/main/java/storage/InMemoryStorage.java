package storage;

import user.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private final static List<User> userList = new ArrayList<>();
    private final static List<Double> resultList = new ArrayList<>();

    public static void addResult(Double num){
        resultList.add(num);
    }

    public boolean register(User user) {
        if (verificationUserLogin(user)) {
            User newUser = new User(user.getName(), user.getLogin(), user.getPass());
            userList.add(newUser);
            return true;
        }
        return false;
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

    public User findByUsername(String name) {
        for (User us : userList) {
            if (us.getName().equals(name)) {
                System.out.println("This UserName exists");
                return us;
            }
        }
        return null;
    }
}

