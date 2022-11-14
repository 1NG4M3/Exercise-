/*1.

Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
значениями 0 3 6 9 12 15 18 21;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
(можно только одну из диагоналей, если обе сложно). Определить элементы одной из
диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0],
[1][1], [2][2], …, [n][n];
5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
помощи интернета);
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть
положительным, или отрицательным), при этом метод должен сместить все элементы массива
на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5,
6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете
выбирать сами.
Если выполнение задач вызывает трудности, можете обратиться к последней странице методического
пособия. Для задач со * не нужно искать решение в интернете, иначе вы теряете весь смысл их
выполнения.

 */

        package lesson2;

import java.sql.PreparedStatement;

public class MainTest {


    public static void main(String[] args) {
        taskOne();
        System.out.println();
        taskTwo();
        System.out.println();
        taskThree();
        System.out.println();
        taskFour();
        System.out.println();
        taskFive();
        System.out.println();
        int[] cat = {1, 2, 1, 1, 2, 1};
        System.out.println("Task six check: ");
        System.out.println(taskSix(cat));
        System.out.println();
        int[] dog = {1, 5, 4, 2};
        int n = 2;
        System.out.println("Task seven check: ");
        System.out.println(taskSeven(dog,n));
        System.out.println();


    }

    public static void taskOne() {
        int[] arrayOne = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arrayTwo = new int[arrayOne.length];
        for (int i = 0; i < arrayOne.length; i++) {
            if (arrayOne[i] == 0) {
                arrayTwo[i] = 1;
            } else {
                arrayTwo[i] = 0;
            }
        }
        for (int i = 0; i < arrayOne.length; i++) {
            System.out.print("arrayOne[" + i + "] = " + arrayOne[i]);
            System.out.println("     arrayTwo[" + i + "] = " + arrayTwo[i]);
        }
    }

    public static void taskTwo() {

        int[] frog = new int[8];

        for (int i = 0, j = 0; j <= 21; i++, j += 3) {
            frog[i] = j;
            System.out.print(i + " ");
            System.out.println(j);
        }

    }

    /*
     3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
     умножить на 2;
*/
    public static void taskThree() {

        int[] mass = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] mass2 = new int[mass.length];

        for (int i = 0; i < mass2.length; i++) {

            if (mass[i] < 6) {
                mass[i] *= 2;
                System.out.print(mass[i] + " ");
            } else {

                System.out.print(mass[i] + " ");


            }
        }

    }
     /*   4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
                одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
                (можно только одну из диагоналей, если обе сложно). Определить элементы одной из
        диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0],
                [1][1], [2][2], …, [n][n];
    */


    public static void taskFour() {
        int square = 5;
        int[][] table = new int[square][square];
        for (int i = 0; i < square; i++) {
            table[i][i] = 1;
            table[i][square - i - 1] = 1;
        }

        System.out.println("Task four check:");
        for (int i = 0; i < square; i++) {
            for (int j = 0; j < square; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    public static void taskFive() {
        int[] sobaka = {9, 212, 121, -4};
        int min = sobaka[0];
        int max = sobaka[0];
        for (int i = 0; i < sobaka.length; i++) {
            if (min >= sobaka[i]) {
                min = sobaka[i];
            } else if (max <= sobaka[i]) {
                max = sobaka[i];

            }


        }
        System.out.println("Task five check:");
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);

    }
        /*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
        массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
        2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
*/


    public static boolean taskSix(int[] cat) {

        int sumCat = 0;
        int leftCat = 0;

        for (int i = 0; i < cat.length; i++) {
            sumCat += cat[i];

        }

        for (int i = 0; i < cat.length; i++) {

            leftCat += cat[i];
            if (leftCat == sumCat - leftCat) {
                return true;
            }
        }
        return false;
    }
        /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть
положительным, или отрицательным), при этом метод должен сместить все элементы массива
    на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
    вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5,
            6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете
    выбирать сами.
    Если выполнение задач вызывает трудности, можете обратиться к последней странице методического
    пособия. Для задач со * не нужно искать решение в интернете, иначе вы теряете весь смысл их
    выполнения.
     */


    public static int taskSeven(int[] dog, int n) {
        int leftStep = 0;
        int rightStep = 0;

        for (int i = 0; i < dog.length; i++) {
            leftStep += dog[n] + i;


        }
        for (int i = 0; i < dog.length; i++) {
           rightStep += dog[n] - i;

            if (rightStep==dog[n]-i) {
                return rightStep;
            }

        }


        return leftStep;
    }
}



