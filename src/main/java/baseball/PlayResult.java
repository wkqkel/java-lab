package baseball;

public class PlayResult {

    private int balls = 0;
    private int strikes = 0;

    public void add(BallResult result) {
        if (result.equals(BallResult.BALL)) {
            balls++;
        } else if (result.equals(BallResult.STRIKE)) {
            strikes++;
        }
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public boolean isNothing() {
        return balls == 0 && strikes == 0;
    }

    public boolean isEnd() {
        return strikes == Game.MAX_BALL_CAPACITY;
    }
}
