package codewars;

import java.util.stream.IntStream;

public class TaskFive {
    public int findSmallestInt(int[] args) {
        int smallest = args[0];
        for (int i = 1; i < args.length; ++i) {
            smallest = Math.min(smallest, args[i]);
        }
        return smallest;
    }

    public static void main(String[] args) {
        int[] array = {78,56,232,12,-1,43};
        int min     = IntStream.of(array).min().getAsInt();
        System.out.println("Minimum: "+min);
    }
}
