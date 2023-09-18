package someTraining;

import java.util.*;
import java.util.stream.Collectors;

public class Sber {
    public static void main(String[] args) {
        String dup = "one";
        String dup2 = "nine";
        String s = "one, two, three, four, one, ten, nine, nine";
        Collection<String> collection = new ArrayList<>(Arrays.asList(s));
        System.out.println(unique(collection));
    }
    public static Collection<String> unique(Collection<String> data){
        return data;
    }
}
