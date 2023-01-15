package tests;

public class Test5 {
    int weight;
    int cost;
    String name;

    public Test5(int weight, int cost, String name) {
        this.weight = weight;
        this.cost = cost;
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Test5 test = (Test5) o;
        return weight == test.weight &&
                cost == test.cost;
    }


    public static void main(String[] args) {
        System.out.println(new Test5(50, 30, "Apple")
                .equals(new Test5(50,30,"Orange")));

        System.out.println(new Test5(30, 10, "Strawberry")
                .equals(new Test5(15, 12, "Lemon")));

        System.out.println(new Test5(10, 50, "Dragon Fruit")
                .equals(new Object()));


    }

    }




