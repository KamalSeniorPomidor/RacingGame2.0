import racingGame.com.Game;
import racingGame.com.GameContext;
public class Main {
    public static void main(String[] args) {
        var context = new GameContext();
        var game = new Game(context);
    }
}