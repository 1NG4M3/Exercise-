package GeekBrainsStage3.lesson2.lesson6;

import java.util.Arrays;

public class FireStarter {

    public static void main(String[] args) {
        FireStarter fs = new FireStarter();
//        int[] a = {1, 2, 3, 4, 5, 6, 7};
//        int[] myTest = fs.foursCutter(a);

        // Вызовет RuntimeException =P
//        System.out.println(Arrays.toString(myTest));
//        fs.foursCutter(new int[] {1, 1, 1, 1});

    }
    /*
    Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
    иначе в методе необходимо выбросить RuntimeException.
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     */

    public int[] foursCutter(int[] array) {
        int index = -1;
        int[] newArray;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                index = i;
            }
        }
        if (index == -1) {
            throw new RuntimeException();
        } else {
            newArray = new int[array.length - index - 1];
        }
        System.arraycopy(array, index + 1, newArray, 0, array.length - index - 1);
        return newArray;
    }


    /*
    3. Написать метод, который проверяет состав массива из чисел 1 и 4.
    Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */

    public boolean fourAndOneSeeker(int[] array) {
        boolean four = false;
        boolean one = false;
        for (int i : array) {
            if (i == 1) {
                one = true;
            } else if (i == 4) {
                four = true;
            }
        }
        if (one && four) {
            return true;
        }
        return false;
    }
}
