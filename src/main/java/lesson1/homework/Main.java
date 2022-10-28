/*
1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
2. Создать переменные всех пройденных типов данных и инициализировать их значения.
3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
где a, b, c, d – аргументы этого метода, имеющие тип float.
4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
5. Написать метод, которому в качестве параметра передается целое число, метод должен
напечатать в консоль, положительное ли число передали или отрицательное. Замечание:
ноль считаем положительным числом.
6. Написать метод, которому в качестве параметра передается целое число. Метод должен
вернуть true, если число отрицательное, и вернуть false если положительное.
7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в
консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й –
високосный.
 */

package lesson1.homework;

public class Main {



    public static float Dima(float a, float b, float c, float d){

        float result = a * (b + (c / d));

        return result;
    }
    public static boolean methodName(int a, int b) {

        int sum = a + b;
        if (sum < 10 && sum > 20) {
            return false;
        } else {
            return true;
        }
    }
        public static void isPositiveOrNegative(int i){
           if (i>=0){
               System.out.println("Positive");

           }
           else {
               System.out.println("Negative");
           }
        }

    public static void main(String[] args) {
        System.out.println(Dima(1,2,4,4));
        System.out.println(methodName(10,7));
        isPositiveOrNegative(100);
        int i;
        i=188;
        float k;
        k=1.2f;
        long w;
        w=111L;
        byte v;
        v=1;
        short q;
        q=20;
        double o;
        o=2.5d;
        char e;
        e='j';
        boolean m;
        m=true;
        String text = "Privet \nDima";
        System.out.println(text);





        }
}
