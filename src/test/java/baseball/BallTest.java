package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void 숫자가_같고_위치가_다르면_볼을_반환한다() {
        // given
        Ball com = new Ball(1, 2);
        Ball player = new Ball(1, 3);

        // when
        BallResult ret = com.compare(player);

        // then
        assertThat(ret).isEqualTo(BallResult.BALL);
    }

    @Test
    void 숫자가_다르면_낫싱을_반환한다() {
        // given
        Ball com = new Ball(1, 2);
        Ball player = new Ball(2, 2);

        // when
        BallResult ret = com.compare(player);

        // then
        assertThat(ret).isEqualTo(BallResult.NOTHING);
    }

    @Test
    void 숫자와_위치가_같으면_스트라이크를_반환한다() {
        // given
        Ball com = new Ball(1, 2);
        Ball player = new Ball(1, 2);

        // when
        BallResult ret = com.compare(player);

        // then
        assertThat(ret).isEqualTo(BallResult.STRIKE);
    }
}
