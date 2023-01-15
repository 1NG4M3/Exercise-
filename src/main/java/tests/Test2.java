package tests;

public class Test2 {

    public static void fun3(){
        int a=3;
        int b;
        int c;
        b=a++;
        c=++a;
        System.out.println(a+"_"+b+"_"+c);
    }

    public static void main(String[] args) {
        fun3();
    }
}

