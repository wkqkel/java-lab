package baseball.view;

import baseball.model.PlayResult;
import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class GameView {
    public static String EMPTY = "";

    public static void start() {
        print("숫자 야구 게임을 시작합니다.");
    }

    public static String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void displayResult(PlayResult result) {
        if (result.isNothing()) {
            print("낫싱", EMPTY);
            return;
        }
        String ret = "";

        if (result.getBalls() > 0) {
            ret += result.getBalls() + "볼";
        }
        if (!ret.isEmpty()) {
            ret += " ";
        }
        if (result.getStrikes() > 0) {
            ret += result.getStrikes() + "스트라이크";
        }

        print(ret);
    }

    public static void end() {
        print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static String restart() {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    private static void print(String message) {
        print(message, "\n");
    }

    private static void print(String message, String end) {
        System.out.print(message + end);
    }

    public static void main(String[] args) {
        print("테스트");
    }
}
