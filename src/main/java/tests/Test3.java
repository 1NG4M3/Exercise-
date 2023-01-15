package tests;


public class Test3 {

    public static void main(String[] args) {

        Person[] employee = new Person[4];
        employee[0] = new Person("Кирилл", 26,"Middle java dev", "150000", "руб" );
        employee[1] = new Person("Виталий", 28,"Senior java automation QA","2000", "$");
        employee[2] = new Person("Александр", 31, "junior functional tester",
                "50000", "руб");
        employee[3] = new Person("Дементий", 35, "dev-ops",
                "1500", "$");

        for (int i = 0; i< employee.length; i++){
            if (employee[i].age<30)
                employee[i].displayInfo();
            System.out.println();
        }

        for (int i=0;i<employee.length;i++){
            employee[i].setCurrency();
            System.out.println();
        }

                double sum = 0;
                sum += employee[0].age+employee[1].age+employee[2].age+employee[3].age;
                double average = sum / employee.length;
                System.out.println("Средний возраст всех сотрудников: " + average);

        }









    }

class Person{

    String name;
    int age;
    String position;
    String salary;
    String currency;



    Person(String name, int age, String position, String salary, String currency)
    {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.currency = currency;

    }


    public void displayInfo(){
        System.out.printf("Name: %s, Age: %d, Position: %s, Salary: %s, Currency: %s",
                name, age, position, salary, currency);
    }

    public void setCurrency(){
       if (currency != "$")
           displayInfo();
    }



}
