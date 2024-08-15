package baseball;

import java.util.ArrayList;
import java.util.List;

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

    public BallResult compare(List<Ball> others){
        List<BallResult> ret = new ArrayList<>();
        for(Ball other : others){
            ret.add(this.compare(other));
        }

        ret.sort((o1, o2)-> o2.ordinal() - o1.ordinal());

        return ret.get(0);
    }
}
