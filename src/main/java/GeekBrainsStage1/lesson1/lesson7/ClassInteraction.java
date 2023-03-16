package GeekBrainsStage1.lesson1.lesson7;

import java.util.Scanner;

public class ClassInteraction {

    public static Plate plate = new Plate(90);

    public static void main(String[] args) {
        hungryCats(catsArray());
        addFoodInPlate(plate);
    }

    public static Cat[] catsArray() {
        // Создаем массив кошек:
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Barsik", 10);
        cats[1] = new Cat("Murzilka", 5);
        cats[2] = new Cat("Murochka", 15);
        cats[3] = new Cat("Biscuit", 10);

        // Проверяем тарелку:
        plate.info();

        // Кормим котов:
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.info();
        }

        // Выводим информацию о сытости котов:
        for (int i = 0; i < cats.length; i++) {
            cats[i].satietyInfo();
        }

        // возвращаем список котов, для следующего метода.
        // как вариант, можно было бы сделать список public, как Plate выше =Р,
        // но, этого не требуется по заданию, а я слишком ленив =)
        return cats;
    }


    public static void hungryCats(Cat[] cats) {
        Cat[] hungry = new Cat[cats.length];
        int position = 0;

        // Создаем массив голодных кошечек
        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].getSatiety()) {
                hungry[position] = cats[i];
                position++;
            }
        }

        // Выводим на экран только голодных кошек
        System.out.println("============================================");
        System.out.println("Список голодных кошек:");
        for (int i = 0; i < hungry.length; i++) {
            if (hungry[i] != null){
                hungry[i].satietyInfo();
            }
        }
    }

    public static void addFoodInPlate(Plate plate) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("Введите число, соответствующее еде, которую вы бы хотели добавить:");
        int addFood = scanner.nextInt();
        plate.setFood(addFood);
        System.out.println("В тарелке стало: " + plate.getFood() + " еды!");
    }
}
