import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    private Bowling game;

    @BeforeEach
    public void init(){
         game =  new Bowling();
    }

    @Test
    public void canRoll(){
        game.roll(0);
    }

    @Test
    public void gameGutterGameWith0(){
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void gameAllOne0sWithALL(){
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void gameWithSpare(){
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void oneStrike(){
        rollStrike();
        game.roll(3);
        game.roll(5);
        rollMany(16,0);
        assertEquals(26, game.score());
    }

    @Test
    public void perfektGame(){
        rollMany(12,10);
        assertEquals(300, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }
    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int quantity, int pins) {
        for (int i = 0; i < quantity ; i++) {
            game.roll(pins);
        }
    }

}
