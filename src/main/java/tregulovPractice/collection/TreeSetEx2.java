package tregulovPractice.collection;

import java.util.Objects;
import java.util.TreeSet;

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet<Student3> treeSet = new TreeSet<>();
        Student3 st1 = new Student3("Zaur", 5);
        Student3 st2 = new Student3("Misha", 1);
        Student3 st3 = new Student3("Igor", 2);
        Student3 st4 = new Student3("Marina", 3);
        Student3 st5 = new Student3("Olya", 4);
        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        Student3 st6 = new Student3("Oleg", 2);
        Student3 st7 = new Student3("Ivan", 4);
        System.out.println(treeSet);
//        System.out.println(treeSet.first()); // получаем студента с наименьшим курсом.
//        System.out.println(treeSet.last()); // получаем студента с наивысшим курсом.
//        System.out.println(treeSet.headSet(st6)); // выводятся студенты с меньшим значением указанным в параметре.
//        System.out.println(treeSet.tailSet(st6)); // выводятся студенты с большем или таким же знаением, как указано в параметре
        System.out.println(treeSet.subSet(st6, st7)); // выводит информацию о тех студентах, у которых курс >=2 или <4.
        System.out.println(st3.equals(st6));
        System.out.println(st3.hashCode()==st6.hashCode());
    }
}
class Student2 implements Comparable<Student3> {
    String name;
    int course;

    public Student2(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public int compareTo(Student3 other) {
        return this.course-other.course;
    }

    @Override
    public String toString() {
        return "Student2{" +
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
