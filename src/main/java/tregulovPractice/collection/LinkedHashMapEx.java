package tregulovPractice.collection;

import java.util.LinkedHashMap;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        LinkedHashMap<Double, Student> lhm = new LinkedHashMap<>(16, 0.75f, true);
        //accessOrder — указывает каким образом будет осуществляться доступ к элементам при использовании итератора.
        // При значении true — по порядку последнего доступа.
        // При значении false доступ осуществляется в том порядке, в каком элементы были вставлены.
        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Sidorov", 2);
        lhm.put(5.8, st1);
        lhm.put(6.4, st2);
        lhm.put(7.5, st4);
        lhm.put(7.2, st3);

        System.out.println(lhm);
        System.out.println(lhm.get(6.4));
        System.out.println(lhm.get(7.5));
        System.out.println(lhm.get(7.2));
        System.out.println(lhm.get(5.8));
        System.out.println(lhm);
    }
}
