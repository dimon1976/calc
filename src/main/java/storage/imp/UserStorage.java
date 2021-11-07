package storage.imp;

import entity.User;

public interface UserStorage {
    boolean save(User user);
    boolean verificationLogin(String userName);
    String findByUsername(String name);
    void delete(User user);
    void edit(User user, String name, String username, String password);
}