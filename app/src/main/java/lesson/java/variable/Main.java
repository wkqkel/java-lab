package lesson.java.variable;

import java.time.YearMonth;

public class Main {

    public static void main(String[] args) {
        String apple1 = "apple";
        String apple2 = "apple";
        String apple3 = "appleapple";

        System.out.println(System.identityHashCode(apple3)); //359023572
        System.out.println(System.identityHashCode("apple" + "apple")); // 359023572
        System.out.println(System.identityHashCode(apple1+ apple2)); // 66557614
        // 1

        switch (apple1) {
            case "APPLE" : {

            }
            case "BANANA" : {

            }
            default: {
            }
        }
    }
}
