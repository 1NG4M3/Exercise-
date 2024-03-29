package tregulovLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
public class StudentInfo {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();
        Predicate<Student> p1 = student -> student.avgGrade>7.5;
        Predicate<Student> p2 = student -> student.sex == 'm';
        info.testStudents(students, p1.and(p2)); // объединяет проверки вместе, выводит инфу, только если прошли все проверки.
        info.testStudents(students, p1.or(p2)); // выводет те элементы, которые удовлетворяют или первой или второй проверки, или обоим.
        info.testStudents(students, p1.negate()); // антоним проверки. выведет обратный результат.
//        Collections.sort(students, (stud1, stud2) -> stud1.course - stud2.course);
//        System.out.println(students);
//        info.testStudents(students, new CheckOverGrade());
//        System.out.println("----------------------------------------------");
//        info.testStudents(students, new StudentChecks() { // Реализация анонимного класса
//            @Override
//            public boolean check(Student s) {
//                return s.age<30;
//            }
//        });
//        info.testStudents(students, (Student s) -> s.avgGrade>8);
//        info.testStudents(students, s -> s.avgGrade>8);
//        StudentChecks sc = (Student s) -> s.avgGrade>8;
//        info.testStudents(students, sc);
        System.out.println("----------------------------------------------");
        info.testStudents(students, (Student s) -> s.age < 30); // Реализация лямбда-выражения ( анонимного метода )
//        System.out.println("----------------------------------------------");
//        info.testStudents(students, (Student s) -> s.age>20 && s.avgGrade <9.3 && s.sex == 'f');
//        info.printStudentOverGrade(students, 8);
//        System.out.println("----------------------------------------------");
//        info.printStudentUnderAge(students, 30);
//        System.out.println("----------------------------------------------");
//        info.printStudentMixCondition(students, 20,9.5,'f');
        Function<Student, Double> f = student -> student.avgGrade;
        double res = avgOfSmth(students, student -> (double)student.age);
        System.out.println(res);
    }
    private static double avgOfSmth(List<Student> list, Function<Student, Double> f) {
        double result = 0;
        for(Student st : list){
            result+=f.apply(st);
        }
        result = result/list.size();
        return result;
    }
    void printStudentOverGrade(ArrayList<Student> al, double grade) {
        for(Student s: al){
            if(s.avgGrade>grade){
                System.out.println(s);
            }
        }

    }
    void printStudentUnderAge(ArrayList<Student> al, int age) {
        for(Student s: al){
            if(s.age<age){
                System.out.println(s);
            }
        }

    }
    void printStudentMixCondition(ArrayList<Student> al, int age, double grade, char sex) {
        for(Student s: al){
            if(s.age > age && s.avgGrade < grade && s.sex == sex){
                System.out.println(s);
            }
        }
    }
    void testStudents(ArrayList<Student> al, Predicate<Student> pr){
        for (Student s: al) {
            if (pr.test(s)){
                System.out.println(s);
            }
        }
    }
}
//interface StudentChecks { //Функциональный интерфейс, содержащий один абстрактный метод, подходит для рабоы с lambda.
//    boolean check(Student s);
//}
//class CheckOverGrade implements StudentChecks {
//
//    @Override
//    public boolean check(Student s) {
//        return s.avgGrade>8;
//    }
//}

