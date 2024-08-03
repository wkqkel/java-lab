package lesson.java.variable;

public class Main {

    public static void main(String[] args) {
        String apple1 = "apple";
        String apple2 = "apple";
        String apple3 = "appleapple";

        System.out.println(apple1 == apple2);
        System.out.println(apple1.equals(apple2));
        System.out.println((apple1 + apple2) == apple3);
        String input = null;
        if("apple".equals(input)) System.out.println("사과");
//        System.out.println(System.identityHashCode(apple3)); //359023572
//        System.out.println(System.identityHashCode("apple" + "apple")); // 359023572
//        System.out.println(System.identityHashCode(apple1+ apple2)); // 66557614
    }
}
