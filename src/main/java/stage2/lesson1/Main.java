package stage2.lesson1;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 5);
        Human human1 = new Human("Petr", 29);
        Robot robot1 = new Robot("Terminator", 1000);
        Cat.info();
        Robot.info();
        Human.info();

    }
}
