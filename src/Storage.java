public class Storage {
    private static User[] data = new User[15];

    public void fillingTheArray(int count, User user) {
        data[count] = user;
    }

    public static boolean register(String name, String login, String pass) {
        boolean b = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                User user = new User(name, login, pass);
                data[i] = user;
                return b;
            } else if (data[i] != null) {
                b = data[i].getLogin().equals(login);
                if (b) {
                    if (data[i].getLogin().equals(login)) {
                        System.out.println("Такой логин существует");
                        return b;
                    }
//                    else if (data[i].getPass().equals(pass)) {
//                        System.out.println("Такой пароль существует");
//                        return b;
//                    }
                }
            }
        }
        return b;
    }


    public static boolean signIn(String name, String login, String pass) {
        boolean c = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                return c;
            } else if (data[i] != null) {
                c = data[i].getLogin().equals(login) & data[i].getPass().equals(pass);
                if (c) {
                    return true;
                }
            }
        }
        return c; // конец блока авторизации
    }


    public static User[] getData() {
        return data;
    }

    public static void setData(User[] data) {
        Storage.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

