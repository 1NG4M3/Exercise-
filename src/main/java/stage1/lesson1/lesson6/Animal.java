package stage1.lesson1.lesson6;

public class Animal {
     public int l=150;
     private static int a;


   public static int countAnimal(){
       a= Cat.number + Dog.number;
       return a;
   }

    static void voice() {
        System.out.print("Бег: " + "Кошка " + Cat.run(200) + " метров," + " Собака " + Dog.runDog(500) + " метров; " );
        System.out.println("Плавание: "  + Cat.swim("Кот не умеет плавать") + ", " + " Собака " + Dog.swimDog(10) + " метров" );
        System.out.println("Котов создано: "+ Cat.number + ", Собак создано: " + Dog.number + ", Животных создано: " + Animal.countAnimal() );
    }
}
