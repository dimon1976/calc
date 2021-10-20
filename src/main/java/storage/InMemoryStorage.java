package storage;

import user.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private final static List<User> data = new ArrayList<>();

//    public void fillingTheArray(int count, User user) {
//        data[count] = user;
//    }

    public static boolean register(String name, String login, String pass) {
        boolean b = false;
        for (User us : data) {
            if (us == null) {
                User user = new User(name, login, pass);
                data.add(user);
                return b;
            } else {
                b = us.getLogin().equals(login);
                if (b) {
                    if (us.getLogin().equals(login)) {
                        System.out.println("Такой логин существует");
                        return b;
                    }
                }
            }
        }
        return b;
    }


    public static boolean signIn(String name, String login, String pass) {
        boolean c = false;
        for (User datum : data) {
            if (datum == null) {
                return c;
            } else {
                c = datum.getLogin().equals(login) & datum.getPass().equals(pass);
                if (c) {
                    return true;
                }
            }
        }
        return false; // конец блока авторизации
    }


//    public static User getData() {
//        return data;
//    }
//
//    public static void setData(User[] data) {
//        InMemoryStorage.data = data;
//    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

