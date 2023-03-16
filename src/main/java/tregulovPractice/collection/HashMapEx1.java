package tregulovPractice.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1000,"Zaur Tregulov");
        map1.put(3568,"Ivan Ivanov");
        map1.put(6578,"Mariya Sidorova");
        map1.put(15879,"Nikolay Petrov");
        map1.putIfAbsent(1000,"Oleg Ivanov");
        System.out.println(map1);
//        System.out.println(map1.get(1001));
//        map1.remove(15879);
//        System.out.println(map1);
//        System.out.println(map1.containsValue("Ivan Ivanov"));
        System.out.println(map1.containsKey(3568));
        System.out.println(map1.keySet());
        System.out.println(map1.values());

        Map<String, String> map2 = new HashMap<>();
        map2.put("Sasha", "Dobryi");
        map2.put("Misha", "Umniy");
        System.out.println(map2);
    }
}
