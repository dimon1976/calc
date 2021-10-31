package entity;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String login;
    private String pass;
    private List<HistoryResult> list;

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

    public List<HistoryResult> getList() {
        return list;
    }

    public void setList(List<HistoryResult> list) {
        this.list = list;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
