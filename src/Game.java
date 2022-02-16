public class Game {


    private int rollCounter =0;
    private int [] rolls = new int[21];

    public void roll(int pinsDown) {
        rolls[rollCounter++] = pinsDown;
    }

    public void roll(int ...rolls) {
        for(int pinsDown: rolls){
            roll(pinsDown);
        }
    }
    public int score() {

        int score = 0;
        int cursor = 0;
        for (int frammes = 0; frammes < 10 ; frammes++) {
            if(isaBoolean(cursor)){
                score += 10 + rolls[cursor+2];
            }else {
                score += rolls[cursor] + rolls[cursor + 1];
                cursor+=2;
            }
        }
        return score;
    }

    private boolean isaBoolean(int cursor) {
        return rolls[cursor] + rolls[cursor + 1] == 10;
    }
}

