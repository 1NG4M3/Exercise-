package tregulovPractice.collection;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Zaur");
        queue.add("Oleg");
        queue.add("Ivan");
        queue.add("Mariya");
        queue.add("Aleksandr");
    //    queue.offer("Dmitry") // Можно использовать метод offer для добавления с ограничением, ели захотим добавить,
        // а мы превысим число, он не добавит и не выбросит ошибку
//        System.out.println(queue);
//        System.out.println(queue.remove()); удаляет и если нет больше элементов, то выдаст ошибку.
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove()); // Выдаст ошибку, если нет больше элементов.
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
       // System.out.println(queue.poll());// При удалении выдаст null, если нет больше элементов.
       // System.out.println(queue.element());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

//        System.out.println(queue);
    }
}
