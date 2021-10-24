package entity;

import java.util.List;

public class User {
    private String name;
    private String login;
    private String pass;
    private List<Double> resultList;

    public User(String name, String login, String pass) {
        this.name = name;
        this.login = login;
        this.pass = pass;
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

    public List<Double> getResultList() {
        return resultList;
    }

    public void setResultList(List<Double> resultList) {
        this.resultList = resultList;
    }
}