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
    public void gameGutterGameWith0(){
        //When
        rollMany(20, 0);
        //Except
        assertEquals(0, game.score());
    }

    @Test
    public void gameAllOne0sWithALL(){
        //When
        rollMany(20, 1);
        //Except
        assertEquals(20, game.score());
    }

    @Test
    public void gameWithSpare(){
        //When
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        //Except
        assertEquals(16, game.score());
    }

    @Test
    public void oneStrike(){
        //When
        rollStrike();
        game.roll(3);
        game.roll(5);
        rollMany(16,0);
        //Except
        assertEquals(26, game.score());
    }

    @Test
    public void perfektGame(){
        //When
        rollMany(12,10);

        //Except
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
