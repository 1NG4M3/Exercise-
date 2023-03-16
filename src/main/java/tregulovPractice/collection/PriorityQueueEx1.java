package tregulovPractice.collection;

import java.util.PriorityQueue;

public class PriorityQueueEx1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(10);
        priorityQueue.add(8);
        // Сортировка будет такой: 1 4 7 8 10. Наивысший приоритет будет у первого элемента.
        // System.out.println(priorityQueue.peek()); // Покажет элемент с наивысшим приоритетом.
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        // Когда выводм на экран, сортировки нет, когда используем элемент, он отображается согласно приоритетности.
    }
}
