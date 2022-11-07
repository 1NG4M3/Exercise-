import java.util.Scanner;
import java.util.Random;

public class MyHomeWork {



    /*Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3
попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли
указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).*/

    public static void main(String[] args) {
        simpleTask();
        System.out.println();






        }

        public static void simpleTask(){
            Random rand = new Random();
            int x = rand.nextInt(10);
            Scanner in = new Scanner(System.in);
            System.out.print("Введите число: ");
            int num = in.nextInt();









        for (int z = 0; z<3;z++){
            if(num < x)
            System.out.println("Указанное число: " + num + ",меньше загаданного");
            break;

        }

        for (int j=0;j<3;j++){
            if(num> x)
            System.out.println("Указанное число: " + num + ",больше загаданного");
            break;





        }
        for (int v=0;v<3;v++){
            if(num==x)
                System.out.println("Вы угадали загаданное число: "+ num);
            break;





        }
            System.out.println("Повторить игру еще раз?");
            System.out.println("1 – да / 0 – нет");
            System.out.println("Введите число: ");
            Scanner in2 =new Scanner(System.in);
            int num2= in2.nextInt();






        }
}
