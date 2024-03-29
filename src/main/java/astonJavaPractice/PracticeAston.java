package astonJavaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
1. Кодинг:
Реализовать - вычисление факториала (нерекурсивное и рекурсивное), вычисления числа фибоначчи, разворот массива,
разбиение строки.
2. Stream API:
Создать коллекцию целых чисел,  написать методы:
2.1. Который отрицательные числа делает положительными и возвращает коллекцию ([1, 5, -3, 7] -> [1, 5, 3, 7])
2.2. Который четные числа умножает на 100, а от нечетных отнимает 100 и возвращает коллекцию
Количество принимаемых и возвращаемых элементов коллекций должно совпадать
2.3. Есть стринговый лист фамилий, нужно пройтись по списку, вытащить фамилии которые начинаются на А и
поместить их в другой список для дальнейшей работы с ними
 */
public class PracticeAston {
    public static void main(String[] args) {
        System.out.println(getFactorial(8));

        System.out.println(getFactorialRecurse(8));

        fibonacciNumbers(8);

        fibonacciNumbersZeroCase(8);

        fibonacciNumbersStream(8);

        Integer[] array = {1,2,3,4,5,6,7,8,9};
        reverse(array);

        String string = "Say hi to aston trainee";
        stringSplit(string);
        System.out.println(cutTheString(string,0,3,6,9,15,23));

        negativeValuesStream();
        x100minus100();
        surnamesAlpha();
    }
    //Нерекурсивное вычисление факториала
    static int getFactorial(int x) {
        int result = 1;
        for (int i = 1; i <=x ; i++) {
            result = result * i;
        }
        return result;
    }
    //Рекурсивное вычисление факториала
    static int getFactorialRecurse(int x) {
        if (x<=1) {
            return 1;
        }else{
            return x*getFactorialRecurse(x-1);
        }
    }
    //Вычисление числа Фибоначчи (случай 0,1)
    static void fibonacciNumbers(int x) {
        int [] arr = new int[x];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }
    //Вычисление числа Фибоначчи (случай 0,0)
    static void fibonacciNumbersZeroCase(int x) {
        int [] arr = new int[x];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }
    //Вычисление числа Фибоначи через Stream (случай 0,1)
    static void fibonacciNumbersStream(int limitX) {
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(limitX)
                .map(y->y[0])
                .forEach(System.out::println);
    }
    //Разворот массива
    static void reverse(Integer[] array) {
        Collections.reverse(Arrays.asList(array));
        for (Integer x : array) {
            System.out.println(x);
        }
    }
    //Разбиение строки через split
    static void stringSplit(String str) {
        String[] strArray = str.split(" ");
        for (String s : strArray) {
            System.out.println(s);
        }
    }
    //Разбиение строки используя substring и varargs
    static List<String> cutTheString(String word, Integer...indexes) {
        int startIndex = indexes[0];
        List<String>cutterList = new ArrayList<>();
        for (int i = 1; i < indexes.length ; i++) {
            cutterList.add(word.substring(startIndex, indexes[i]).trim());
            startIndex=indexes[i];
        }
        return cutterList;
    }

    //Метод, который отрицательные числа делает положительными и возвращает коллекцию
    static void negativeValuesStream() {
        Stream<Integer>numStream = Stream.of(1, -5, 10, -15, 20, -25);
        List<Integer>negativeValues = numStream.map(x->x<0?x*-1:x).collect(Collectors.toList());
        System.out.println(negativeValues);
    }
    //Метод, который четные числа умножает на 100, а от нечетных отнимает 100 и возвращает коллекцию
    //Количество принимаемых и возвращаемых элементов коллекций должно совпадать
    static void x100minus100() {
        Stream<Integer>numStream = Stream.of(34, -3, 12, -15, 20, -25);
        List<Integer>list = numStream.map(x->x%2==0?x*100:x-100).collect(Collectors.toList());
        System.out.println(list);
    }
    //Есть стринговый лист фамилий, нужно пройтись по списку, вытащить фамилии которые начинаются на А и
    //поместить их в другой список для дальнейшей работы с ними
    static void surnamesAlpha() {
        Stream<String>surnames = Stream.of
                ("Marchenko", "Kunitsa", "Saraev", "Beliaev", "Alekseev", "Kashtanov", "Andreev");
        List<String>list = surnames.filter(x->x.startsWith("A")).collect(Collectors.toList());
        System.out.println(list);
    }
}