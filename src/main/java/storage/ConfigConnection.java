package storage;

public class ConfigConnection {
    private final String url = "jdbc:mysql://localhost/calc?useUnicode=true&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "root";

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
