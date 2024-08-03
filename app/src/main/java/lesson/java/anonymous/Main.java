package lesson.java.anonymous;

interface Dog {
    void run();
}
public class Main {
    public static void main(String[] args) {
        Dog dog = () -> System.out.println("멍멍");
        dog.run();
    }
}
