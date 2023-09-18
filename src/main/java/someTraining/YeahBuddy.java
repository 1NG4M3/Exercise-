package someTraining;

public class YeahBuddy {
    private String name;
    private Integer age;
    private String secondName;

    public YeahBuddy(String name, Integer age, String secondName) {
        this.name = name;
        this.age = age;
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public static int changeData (String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Произошла ошибка форматов данных");
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(changeData("923"));
    }
}
