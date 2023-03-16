package tregulovNestedClasses.inner_class;

public class Car2 {
    String color;
    int doorCount;
    Car2.Engine2 engine;

    public Car2(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
//        this.engine = this.new Engine2(horsePower); // Мотор создается внутри конструктора Car2
    }
    public void setEngine(Engine2 engine2) {
        this.engine = engine2;
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public class Engine2 {
        int horsePower;

        public Engine2(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "My Engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        Car2 car2 = new Car2("black", 4);
        Car2.Engine2 engine2 = car2.new Engine2(150);
        car2.setEngine(engine2);
        System.out.println(engine2);
        System.out.println(car2);
    }
}
