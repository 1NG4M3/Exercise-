package tregulovStreams;

import java.util.Arrays;
import java.util.List;


public class Ask {
    public static void main(String[] args) {
        List<Object> data = Arrays.asList("A", "B", Arrays.asList("D", Arrays.asList("E", "F")), "C");
        dataChanger(data,1);
    }

    public static void dataChanger(List<Object> data, int level) {
        for (Object item : data) {
            if (item instanceof String) {
                System.out.println("-".repeat(level) + " " + item);
            } else if (item instanceof List) {
                dataChanger((List<Object>) item, level + 1);
            }
        }
    }
}
