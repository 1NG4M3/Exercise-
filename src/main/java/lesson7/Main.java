package lesson7;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 70);
        Plate plate = new Plate(90);
        plate.info();
        cat.eat(plate);
       // plate.setFood(plate.getFood() - cat.getAppetite());
        plate.info();
    }
}