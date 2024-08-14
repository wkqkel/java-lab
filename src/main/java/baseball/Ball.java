package baseball;

public class Ball {

    int num;
    int pos;

    public Ball(int num, int pos) {
        this.num = num;
        this.pos = pos;
    }

    public BallResult compare(Ball other) {
        if (this.num != other.num) {
            return BallResult.NOTHING;
        }
        if (this.pos != other.pos) {
            return BallResult.BALL;
        }
        return BallResult.STRIKE;
    }
}
