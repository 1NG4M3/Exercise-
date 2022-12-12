package lesson5;
/*1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
        2. Конструктор класса должен заполнять эти поля при создании объекта.
        3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в
        консоль.
        4. Создать массив из 5 сотрудников.
        Пример:
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",
        30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person(...);
        ...
        persArray[4] = new Person(...);
        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.

 */
public class Employee {

    public static void main(String[] args) {

      //  Person undef = new Person();
      //  undef.displayInfo();

       // Person tom = new Person("Tom");
       // tom.displayInfo();

      //  Person sam = new Person("Sam");
      //  sam.displayInfo();
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Dmitry", "boss","dmitrygusev@mail.ru", 895122705,
                777, 45 );
        persArray[1] = new Person("Alex", "mainEngineer","alexfedorov@mail.ru", 89112224,
                999, 39 );
        persArray[2] = new Person("Fedor", "secondEngineer", "fedorteodor@mail.ru",
                89224445, 555, 46);
        persArray[3] = new Person("Pavel", "headOfDepartment", "paveldenisov@mail.ru",
                8999222, 444, 37);
        persArray[4] = new Person("Ivan", "cleaner", "ivanivanov@mail.ru",
                89994566, 120, 59);

            for (int i = 0; i< persArray.length; i++){
                if (persArray[i].age>40)
                persArray[i].displayInfo();
                System.out.println();
            }








    }

}
class Person{

    String name;
    String position;
    String email;
    int numberPhone;
    int salary;
    int age;

    Person(String name, String position, String email, int numberPhone, int salary, int age)
    {
        this.name = name;
        this.position = position;
        this.email = email;
        this.numberPhone = numberPhone;
        this.salary = salary;
        this.age = age;
    }


   public void displayInfo(){
        System.out.printf("Name: %s, Position: %s, email: %s, NumberPhone: %d, Salary: %d, Age: %d", name, position, email, numberPhone, salary, age);
    }

}





