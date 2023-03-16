package tregulovPractice.collection;

public class StackExample {
    static void abs1() {
        System.out.println("abc1 starts");
        System.out.println("abc1 ends");
    }

    static void abs2() {
        System.out.println("abc2 starts");
        abs1();
        System.out.println("abc2 ends");
    }

    static void abs3() {
        System.out.println("abc3 starts");
        abs2();
        System.out.println("abc3 ends");
    }

    public static void main(String[] args) {
        System.out.println("main starts");
        abs3();
        System.out.println("main ends");
    }
}
