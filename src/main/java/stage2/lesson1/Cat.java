package stage2.lesson1;

public class Cat implements WorkingSpace {
    public static String  name;
    public static int age;

    public Cat(String name, int age) {
        this.name=name;
        this.age=age;

    }
public static void info(){
    System.out.println(name + ": Я умею бегать и прыгать");
}
}