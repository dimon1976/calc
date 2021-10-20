import service.Mathematic;
import service.Menu;
import storage.InMemoryStorage;

public class Main {
    public static void main(String[] args) {

        Mathematic mathematic = new Mathematic();
        Menu.start(mathematic);
    }
}