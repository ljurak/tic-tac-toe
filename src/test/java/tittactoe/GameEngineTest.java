package tittactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameEngineTest {

    private GameEngine game;

    @BeforeEach
    public void setUp() {
        game = new GameEngine();
        game.initGame();
    }

    @Test
    public void shouldInitGame() {
        // then
        assertNotNull(game.getCurrentPlayer());
        assertFalse(game.isVictory());
        assertFalse(game.isFinished());
    }

    @Test
    public void shouldChangePlayer() {
        // given
        GamePlayer previousPlayer = game.getCurrentPlayer();

        // when
        game.changePlayer();

        // then
        assertFalse(previousPlayer == game.getCurrentPlayer());
    }

    @Test
    public void shouldCheckThereIsNoVictoryAndGameIsNotFinished() {
        // given
        game.setBoardValue(0);
        game.changePlayer();
        game.setBoardValue(1);
        game.changePlayer();
        game.setBoardValue(2);
        game.changePlayer();
        game.setBoardValue(3);
        game.changePlayer();
        game.setBoardValue(4);

        // when
        game.checkVictory();

        // then
        assertFalse(game.isVictory());
        assertFalse(game.isFinished());
    }

    @Test
    public void shouldCheckThereIsNoVictoryAndGameIsFinished() {
        // given
        game.setBoardValue(1);
        game.changePlayer();
        game.setBoardValue(0);
        game.changePlayer();
        game.setBoardValue(2);
        game.changePlayer();
        game.setBoardValue(4);
        game.changePlayer();
        game.setBoardValue(3);
        game.changePlayer();
        game.setBoardValue(5);
        game.changePlayer();
        game.setBoardValue(7);
        game.changePlayer();
        game.setBoardValue(6);
        game.changePlayer();
        game.setBoardValue(8);

        // when
        game.checkVictory();

        // then
        assertFalse(game.isVictory());
        assertTrue(game.isFinished());
    }

    @Test
    public void shouldCheckThereIsVictory() {
        // given
        game.setBoardValue(0);
        game.changePlayer();
        game.setBoardValue(1);
        game.changePlayer();
        game.setBoardValue(2);
        game.changePlayer();
        game.setBoardValue(3);
        game.changePlayer();
        game.setBoardValue(4);
        game.changePlayer();
        game.setBoardValue(5);
        game.changePlayer();
        game.setBoardValue(6);

        // when
        game.checkVictory();

        // then
        assertTrue(game.isVictory());
        assertTrue(game.isFinished());
    }
}
