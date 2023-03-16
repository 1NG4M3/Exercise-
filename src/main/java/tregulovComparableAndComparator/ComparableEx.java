package tregulovComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Zaur");
        list.add("Ivan");
        list.add("Mariya");

        System.out.println("Pered");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("Posle");
        System.out.println(list);

    }
}
