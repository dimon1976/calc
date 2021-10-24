package storage;

import entity.User;

import java.util.ArrayList;
import java.util.List;


public class InMemoryStorage {
    private final static List<User> userList = new ArrayList<>();

    public static void addUserList(User user) {
        userList.add(user);
    }

    public static List<User> getUserList(){
        return userList;
    }
}
