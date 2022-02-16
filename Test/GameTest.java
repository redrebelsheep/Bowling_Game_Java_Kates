import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private Game game;

    @BeforeEach
    public void init() {
        game = new Game();
    }


    @Test
    public void canRollBall() {
        game.roll(0);
    }

    @Test
    public void canScorGutterGame() {
        game. roll(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(0, game.score());

    }

    @Test
    public void canScoreGameOofOnes() {
        game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void canScoreSpareFollowedByThree() {
        game.roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(16, game.score());
    }

}