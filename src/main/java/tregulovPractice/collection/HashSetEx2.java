package tregulovPractice.collection;

import java.util.HashSet;

public class HashSetEx2 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(2);
        hashSet1.add(3);
        hashSet1.add(1);
        hashSet1.add(8);

        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(7);
        hashSet2.add(4);
        hashSet2.add(3);
        hashSet2.add(5);
        hashSet2.add(8);

//        HashSet<Integer> union = new HashSet<>(hashSet1); // Добавляем в параметры значения hashSet1
//        union.addAll(hashSet2);   // Объеденяем значения hashSet2 и hashSet1 без добавления одинаковых чисел.
//        System.out.println(union);

//        HashSet<Integer> intersect = new HashSet<>(hashSet1);
//        intersect.retainAll(hashSet2); // Сохраняет только те элементы коллекции, которые содержатся в указанной коллекции.
//        System.out.println(intersect);

        HashSet<Integer> subtract = new HashSet<>(hashSet1);
        subtract.removeAll(hashSet2); // Удаляет из hashSet1 все элементы hashSet2. Останутся только те элементы,
        // которые есть в hashSet1, но нет в hashSet2.
        System.out.println(subtract);
    }
}
