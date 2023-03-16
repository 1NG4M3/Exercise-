package tregulovPractice.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Zaur");
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");
        set.remove("Zaur");
//        set.add("Igor"); // Множество HashSet не может содержать дубликатов.
//        set.add(null); // HashMap, который сидит в основе HashSet, допускает добавление null.
//        System.out.println(set);
        for(String s: set) {
            System.out.println(s);
        }
        System.out.println(set.size()); // Размер массива
        System.out.println(set.isEmpty()); // Пуст массив или нет
        System.out.println(set.contains("Misha")); // Есть ли данный элемент в массиве?
    }
}
