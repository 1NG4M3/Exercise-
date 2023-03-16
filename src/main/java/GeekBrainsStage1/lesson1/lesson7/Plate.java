package GeekBrainsStage1.lesson1.lesson7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }

    /*public void decreaseFood(int n) {
        if (n<=food) {
            food -= n;
            System.out.println("Кот покушал и сыт");

        } else {
             System.out.println("Не хватает еды в миске");
        }

    }*/
    public int getFood() {
        return this.food;
    }

 /*  public void setFood(int newFoodInPlate) {
        this.food = newFoodInPlate;
    }*/
    public void setFood(int food) {
        this.food = food;
    }

   /* public Plate(int food) {
        this.food = food;
    }*/

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

