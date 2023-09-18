package tregulov_work_with_files.programmer1;

import java.io.Serializable;

public class Employee implements Serializable {
    String name;
    String surname;
    String department;
   transient double salary;
    Car car;

    public Employee(String name, String surname, String department, double salary, Car car) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                "surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}
