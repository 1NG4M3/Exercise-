package tregulovGenerics;

import java.util.ArrayList;
import java.util.List;

public class GenericsEx1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("ok");
//        list.add(12);
//        list.add(new StringBuilder("1"));
//        list.add(new Car());

        list.add("privet");
        list.add("poka");
        list.add("prt");
        list.add("priasdasdavet");

        for (Object o : list) {
            System.out.println(o + " dlina: " + ((String) o).length());
        }
    }
}

class Car {
}


