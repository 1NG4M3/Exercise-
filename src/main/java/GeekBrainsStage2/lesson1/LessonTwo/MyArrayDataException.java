package GeekBrainsStage2.lesson1.LessonTwo;

public class MyArrayDataException extends Exception {
    public int i;
    public int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
