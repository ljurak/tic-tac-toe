package tittactoe;

public class GameEngine {

    private GamePlayer[] board;

    private GamePlayer currentPlayer;

    private int movesCount = 0;

    private boolean isFinished = false;

    private boolean isVictory = false;

    private int[][] victoryCombinations = {
        { 0, 1, 2 },
        { 3, 4, 5 },
        { 6, 7, 8 },
        { 0, 3, 6 },
        { 1, 4, 7 },
        { 2, 5, 8 },
        { 0, 4, 8 },
        { 2, 4, 6 }
    };

    public void initGame() {
        board = new GamePlayer[9];
        setCurrentPlayer(Math.random() < 0.5 ? GamePlayer.CROSS : GamePlayer.CIRCLE);
        movesCount = 0;
        isFinished = false;
        isVictory = false;
    }

    public void changePlayer() {
        setCurrentPlayer(getCurrentPlayer() == GamePlayer.CROSS ? GamePlayer.CIRCLE : GamePlayer.CROSS);
    }

    public GamePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean isVictory() {
        return isVictory;
    }

    public GamePlayer getBoardValue(int index) {
        if (index < 0 || index >= board.length) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return board[index];
    }

    public boolean setBoardValue(int index) {
        if (index < 0 || index >= board.length) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (board[index] != null) {
            return false;
        }

        board[index] = getCurrentPlayer();
        movesCount++;
        return true;
    }

    public boolean checkVictory() {
        for (int[] arr : victoryCombinations) {
            if (board[arr[0]] == getCurrentPlayer() && board[arr[1]] == getCurrentPlayer() && board[arr[2]] == getCurrentPlayer()) {
                isVictory = true;
                isFinished = true;
                return true;
            }
        }
        if (movesCount == board.length) {
            isFinished = true;
        }
        return false;
    }

    private void setCurrentPlayer(GamePlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
