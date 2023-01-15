package tests;

public class Test4 {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {5, 7, 9, 2, 1},
                {0, 9, 1, 8, 7},
                {6, 3, 6, 6, 6},
                {99, 100, -2, 3, 1}
        };
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int mins = 1000; // задаем значение заведомо больше, чем все элементы массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[2][2] != array[i][i])
                    mins = Math.min(array[array.length - 1 - i][i], mins);
            }

        }


        System.out.println("Минимальный элемент побочной диагонали: " + mins);
    }
}
