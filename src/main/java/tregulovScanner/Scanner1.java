package tregulovScanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vvedite chislo");
        int i = scanner.nextInt();
        System.out.println("Vvedennoe chislo: " + i);
        System.out.println("Napishite 2 chisla");

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("Chastnoe = " + x / y);
        System.out.println("Ostatok = " + x % y);

        System.out.println("Napishite dve stroki");
        String s1 = scanner.next();
        System.out.println("Vi napisali v pervoy stroke: " + s1);

        System.out.println("Vvedite drobnoe chislo");
        double d = scanner.nextDouble();
        System.out.println("Vvedennoe chislo: " + d);

        Scanner scanner1 = new Scanner("Privet moy drug!\nKak pozivaesh?" +
                "\nChto xoroshego?");

        String s2 = scanner1.nextLine();
        System.out.println(s2);
        System.out.println(scanner1.nextLine());
        System.out.println(scanner1.nextLine());
        System.out.println(scanner1.nextLine());

        while (scanner1.hasNextLine()) {
            System.out.println(scanner1.nextLine());
        }

        System.out.println(scanner1.next().charAt(2));
        scanner.close();
        scanner1.close();
    }
}