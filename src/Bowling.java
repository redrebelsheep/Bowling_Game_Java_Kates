public class Bowling {

    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pinsFall) {
        rolls[currentRoll++] = pinsFall;
    }

    public int score() {
        int score = 0;
        int firstInFrame = 0;
        for (int frame = 0; frame < 10; frame++) {

            if(isStrike(firstInFrame)){
                score += getRollForStrike(firstInFrame);
                firstInFrame++;
            }else if (isSpare(firstInFrame)) {
               score +=  getRollForSpare(firstInFrame);
               firstInFrame += 2;
            } else {
                score += getScore(firstInFrame);
                firstInFrame += 2;
            }
        }
        return score;
    }

    private int getRollForStrike(int firstInFrame) {
        return 10 + rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    private boolean isStrike(int firstInFrame) {
        return rolls[firstInFrame] == 10;
    }

    private int getScore(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    private int getRollForSpare(int firstInFrame) {
        return 10 + rolls[firstInFrame + 2];
    }

    private boolean isSpare(int i) {
        return rolls[i] + rolls[i] == 10;
    }
}
