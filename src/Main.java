import service.Mathematic;
import service.Menu;
import storage.InMemoryStorage;
import user.User;

public class Main {
    public static void main(String[] args) {

        InMemoryStorage users = new InMemoryStorage();
        int i = 0;

        User user1 = new User("Bob", "login", "pass");
        users.fillingTheArray(i, user1);
        i++;
        User user2 = new User("Vasya", "login2", "pass2");
        users.fillingTheArray(i++, user2);
        User user3 = new User("Nik", "login3", "pass3");
        users.fillingTheArray(i++, user3);
        User user4 = new User("Stas", "login4", "pass4");
        users.fillingTheArray(i++, user4);
        User user5 = new User("Dima", "login5", "pass5");
        users.fillingTheArray(i++, user5);
        Mathematic mathematic = new Mathematic();
        Menu.start(mathematic);
    }
}