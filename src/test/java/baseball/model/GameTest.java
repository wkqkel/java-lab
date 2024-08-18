package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameTest {

    @Test
    void 게임_생성_시_컴퓨터_볼이_3개_생성된다() {
        Game game = new Game();

        assertThat(game.getComBalls().size()).isEqualTo(Game.MAX_BALL_CAPACITY);
    }

    @Test
    void 다_맞출_경우에는_게임이_종료된다() {
        // given
        String com = "123";
        Game game = new Game(com);

        // when
        PlayResult ret = game.play("123");

        // then
        assertThat(ret.isEnd()).isTrue();
    }

    @Test
    void 일치하는_숫자가_없으면_낫싱을_리턴한다() {
        // given
        String com = "123";
        Game game = new Game(com);

        // when
        PlayResult ret = game.play("456");

        // then
        assertThat(ret.isNothing()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("provide")
    void 일치하는_숫자에_따라_올바른_결과를_리턴한다(String playerNumber, int strikes, int balls) {
        // given
        String com = "123";
        Game game = new Game(com);

        // when
        PlayResult ret = game.play(playerNumber);

        // then
        assertThat(ret.getStrikes()).isEqualTo(strikes);
        assertThat(ret.getBalls()).isEqualTo(balls);
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of("124", 2, 0),
                Arguments.of("213", 1, 2),
                Arguments.of("123", 3, 0),
                Arguments.of("456", 0, 0),
                Arguments.of("451", 0, 1)
        );
    }

}
