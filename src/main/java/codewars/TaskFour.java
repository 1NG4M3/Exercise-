package codewars;

//Create a function that takes an integer as an argument and returns "Even" for even numbers or "Odd" for odd numbers.

import java.util.Scanner;

public class TaskFour {
    public static String even_or_odd(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    public static void main(String[] args) {
        System.out.println(even_or_odd(22));
    }
}
