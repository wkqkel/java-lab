package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("provideBallForCompareBallList")
    void 다수_비교시_가장_높은_순위를_반환한다(int num, int pos, BallResult guess){
        // given
        List<Ball> com = new ArrayList<>();
        com.add(new Ball(1, 1));
        com.add(new Ball(2, 2));
        com.add(new Ball(3, 3));

        Ball player = new Ball(num, pos);
        // when
        BallResult ret = player.compare(com);

        // then
        assertThat(ret).isEqualTo(guess);
    }

    private static Stream<Arguments> provideBallForCompareBallList() {
        return Stream.of(
                Arguments.of(3, 3, BallResult.STRIKE),
                Arguments.of(3, 2, BallResult.BALL),
                Arguments.of(5, 2, BallResult.NOTHING)
        );
    }


}
