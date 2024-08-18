package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Ball {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private final int num;
    private final int pos;

    public Ball(int num, int pos) {
        if (num < MIN_NUM || num > MAX_NUM) {
            String message = String.format("%d~%d 사이의 값만 올 수 있습니다", MIN_NUM, MAX_NUM);

            throw new IllegalArgumentException(message);
        }

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

    public BallResult compare(List<Ball> others) {
        List<BallResult> ret = new ArrayList<>();
        for (Ball other : others) {
            ret.add(this.compare(other));
        }

        ret.sort((o1, o2) -> o2.ordinal() - o1.ordinal());

        return ret.get(0);
    }
}
