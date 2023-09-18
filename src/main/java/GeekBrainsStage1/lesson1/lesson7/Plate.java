package GeekBrainsStage1.lesson1.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return this.food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Plate: " + food);
    }

    public boolean decreaseFood(int appetite) {
        if (appetite > food) {
            System.out.println("В тарелке слишком мало еды, для этого кота.");
            return false;
        } else {
            food -= appetite;
        }
        return true;
    }
}

