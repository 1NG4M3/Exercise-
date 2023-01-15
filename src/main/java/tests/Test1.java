package tests;

public class Test1 {
    public static void main(String[] args) {
        int[] arraylist = {1, 5, 3, 2, 10, 15, 9, 8, 7};
        System.out.print("Массив до сортировки: ");
        for (int i = 0; i < arraylist.length; i++)
            System.out.print(arraylist[i] + " ");
        System.out.println("");
        arraylist = sort(arraylist);
        System.out.print("Массив после сортировки: ");
        for (int i = 0; i < arraylist.length; i++)
            System.out.print(arraylist[i] + " ");
    }

    public static int[] sort(int x[]) {
        if (x.length == 1)
            return x;
        else {
            int half = (int) Math.floor(x.length / 2);
            int halfFirst[] = new int[half];
            int halfSecond[] = new int[x.length - half];
            for (int i = 0; i < x.length; i++) {
                if (i < half)
                    halfFirst[i] = x[i];
                else
                    halfSecond[i - half] = x[i];
            }
            halfFirst = sort(halfFirst);
            halfSecond = sort(halfSecond);
            x = sortNext(halfFirst, halfSecond);
            return x;
        }
    }

    public static int[] sortNext(int x[], int y[]) {
        int c[] = new int[x.length + y.length];
        int a = 0, b = 0;
        for (int i = 0; i < x.length + y.length; i++) {
            if (a == x.length) {
                c[i] = y[b];
                b++;
            } else if (b == y.length) {
                c[i] = x[a];
                a++;
            } else if (x[a] > y[b]) {
                c[i] = y[b];
                b++;
            } else {
                c[i] = x[a];
                a++;
            }
        }
        return c;
    }
}
