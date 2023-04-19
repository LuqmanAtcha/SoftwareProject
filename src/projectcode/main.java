package projectcode;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<String> playerNames = Arrays.asList("Luqman", "Devjeet", "Khalil", "Mark");
        Game game = new Game(playerNames);
        game.play();
    }
}
