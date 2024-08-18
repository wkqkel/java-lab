package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Game {

    public static final int MAX_BALL_CAPACITY = 3;
    private List<Ball> comBalls = new ArrayList<>(MAX_BALL_CAPACITY);

    public Game() {
        this(generateRandomNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining("")));
    }

    public Game(String com) {
        this.comBalls = makeBalls(com);
    }

    public PlayResult play(String playerNumber) {
        validatePlayerInput(playerNumber);

        return play(makeBalls(playerNumber));
    }

    public PlayResult play(List<Ball> playerBalls) {
        PlayResult ret = new PlayResult();
        for (Ball comBall : comBalls) {
            ret.add(comBall.compare(playerBalls));
        }
        return ret;
    }

    public List<Ball> getComBalls() {
        return this.comBalls;
    }

    private List<Ball> makeBalls(String number) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < MAX_BALL_CAPACITY; i++) {
            balls.add(new Ball(number.charAt(i) - '0', i));
        }
        return balls;
    }


    private static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_BALL_CAPACITY) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private void validatePlayerInput(String input) {
        if (input.length() != MAX_BALL_CAPACITY) {
            throw new IllegalArgumentException("입력된 숫자는 " + MAX_BALL_CAPACITY + "개여야 합니다.");
        }

        long uniqueCount = input.chars().distinct().count();
        if (uniqueCount != MAX_BALL_CAPACITY) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
        }
    }
}
