package GeekBrainsStage1.lesson1.lesson3;

import java.util.Scanner;
import java.util.Random;

public class MyHomeWork {



    /*Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3
попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли
указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).*/

    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();


    public static void main(String[] args) {
        greetings();
        repeatTheGame();
    }



    public static void theGame() {
        int answer = rand.nextInt(10);
        int x;
        int counter = 3;

        do {
            System.out.println("Ваш ответ:");
            x = scanner.nextInt();
            if (x < answer) {
                System.out.println("Загаданное число больше!");
                counter--;
                System.out.println("Осталось попыток: " + counter);
            } else if (x > answer) {
                System.out.println("Загаданное число меньше!");
                counter--;
                System.out.println("Осталось попыток: " + counter);
            } else {
                System.out.println("Поздравляем! Вы выиграли!!!");
            }
        } while (counter > 0 && x != answer);

        if (counter == 0){
            System.out.println("Вы проиграли! Может повезет в следующий раз!?");
        }
    }


    public static void greetings() {
        System.out.println("Вас приветствует игра Угадай число!");
        System.out.println("Вам необходимо угадать число, загаданное компьютером.");
        System.out.println("На это вам дается три попытки!");
        System.out.println("Начнем!");
    }


    public static void repeatTheGame() {
        int repeat;
        do{
            theGame();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            repeat = scanner.nextInt();
        } while (repeat == 1);
    }
        }








