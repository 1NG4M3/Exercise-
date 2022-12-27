package lesson7;

import java.sql.Struct;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean getSatiety() {
        return satiety;
    }
    public void eat(Plate plate) {
        System.out.println(name + " try to eat!");
        if (plate.decreaseFood(appetite)) {
            System.out.println("Котик покушал!");
            satiety = true;
        } else {
            System.out.println("Котик не покушал!");
        }
    }

    public void satietyInfo() {
        if (!satiety) {
            System.out.println("Котик " + name + " голоден!");
        } else {
            System.out.println("Котик " + name + " сыт и счастлив!");
        }
    }

}
