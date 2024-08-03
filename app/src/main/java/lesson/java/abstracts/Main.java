package lesson.java.abstracts;



public class Main {
    public static void main(String[] args) {
        Weapon sward = new Sward();
        Weapon cane = new Cane();
        Weapon bow = new Bow();

        sward.print();
        cane.print();
        bow.print();
    }
}
