package tittactoe;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TicTacToe {

    private static Scanner scanner = new Scanner(System.in);

    private static Pattern pattern = Pattern.compile("[1-9]{1}");

    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        GameRenderer renderer = new ConsoleRenderer(game);
        game.initGame();

        while (!game.isFinished()) {
            renderer.render();
            String input;
            do {
                input = scanner.next();
            } while (!pattern.matcher(input).matches() || !game.setBoardValue(Integer.valueOf(input) - 1));
            if (game.checkVictory()) {
                break;
            }
            game.changePlayer();
        }
        renderer.render();
    }
}
