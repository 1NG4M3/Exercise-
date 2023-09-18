import java.util.Arrays;

public class Banjo {
    public static String areYouPlayingBanjo(String name) {
        if (name.toLowerCase().startsWith("r")) {
            return name + " plays banjo";
        } else {
            return name + " does not play banjo";
        }
    }

    public static void main(String[] args) {
        Banjo.areYouPlayingBanjo("Rick");
    }
}

class SmashWords {
    public static String smash(String... words) {
        if (words.length > 1) {
            return String.join(", ", words);
        } else if (words.length == 0) {
            return words[0];
        } else {
            return Arrays.asList(words).toString();
        }
    }
}