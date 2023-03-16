package tregulovPractice.collection;

import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQueueEx2 {
    public static void main(String[] args) {
        Student3 st1 = new Student3("Zaur", 5);
        Student3 st2 = new Student3("Misha", 1);
        Student3 st3 = new Student3("Igor", 2);
        Student3 st4 = new Student3("Marina", 3);
        Student3 st5 = new Student3("Olya", 4);
        PriorityQueue<Student3> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(st1);
        priorityQueue.add(st2);
        priorityQueue.add(st3);
        priorityQueue.add(st4);
        priorityQueue.add(st5);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        // PriorityQueue использует приоритет не смотря на порядок добавления.

    }
}
class Student3 implements Comparable<Student3> {
    String name;
    int course;

    public Student3(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public int compareTo(Student3 other) {
        return this.course - other.course;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student3 student3 = (Student3) o;
        return course == student3.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}