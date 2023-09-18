package someTraining;

public class Frogs extends Animals {
    int age;
    String name;

    public Frogs() {
        super();
    }

    public Frogs(int age, String name){
        this();
        this.age= age;
        this.name = name;
    }

    public static void main(String[] args) {
        Frogs frog = new Frogs();
        Animals animal = new Animals("Cat", 21);
        Animals animals = new Frogs();
        Frogs frog2 = new Frogs(28, "Jaba");
        System.out.println(frog);
        System.out.println(animal);
        System.out.println(animals);
        System.out.println("Жаба Жаба прием " + frog2.name);
    }

    @Override
    public String toString() {
        return "someTraining.Frogs{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
