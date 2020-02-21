package tittactoe;

public class ConsoleRenderer implements GameRenderer {

    private final GameEngine game;

    public ConsoleRenderer(GameEngine game) {
        this.game = game;
    }

    public void render() {
        System.out.println();
        System.out.println("Current player: " + (game.getCurrentPlayer() == GamePlayer.CROSS ? "X" : "O"));
        System.out.println();
        System.out.println("          -------------------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("          |     |     |     |");
            System.out.println("          |  " + getBoardValue(i) + "  |  " + getBoardValue(i + 1) + "  |  " + getBoardValue(i + 2) + "  |");
            System.out.println("          |     |     |     |");
            System.out.println("          -------------------");
        }
        System.out.println();

        if (game.isVictory()) {
            System.out.println("RESULT: " + game.getCurrentPlayer() + " WINS!");
        } else if (game.isFinished()) {
            System.out.println("RESULT: GAME TIED!");
        }
    }

    private String getBoardValue(int index) {
        GamePlayer player = game.getBoardValue(index);
        return player == null
                ? String.valueOf(index + 1)
                : player == GamePlayer.CROSS
                ? "X" : "O";
    }
}
