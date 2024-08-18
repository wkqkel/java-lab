package baseball.utils;

public class Validator {

    public static boolean isNumeric(String str) {
        return str.matches("\\d+"); // 숫자만 포함된 문자열인지 확인
    }
}
