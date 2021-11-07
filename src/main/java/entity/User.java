package entity;

public class User {
    private int id;
    private String name;
    private String login;
    private String pass;
    private int admin;

    public User(int id, String name, String login, String pass) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.pass = pass;
    }

    public User(String name, String login, String pass) {
        this.name = name;
        this.login = login;
        this.pass = pass;
    }

    public User(int id, String name, String login, String pass, int admin) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.pass = pass;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public void setName(String name) {
        this.name = name;
    }

}
