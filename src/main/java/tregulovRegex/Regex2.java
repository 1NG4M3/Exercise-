package tregulovRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
//        String s1 = "ABCD ABCE ABCFABCGABCH";
//        Pattern pattern1 = Pattern.compile("ABC");
//
//        String s1 = "ABDOP";
//        Pattern pattern2 = Pattern.compile("AB[C-F]OP");
//
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern3 = Pattern.compile("abc[^e-g4-7]");
//
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern4 = Pattern.compile("abc(e|5)");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc$");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\D");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w"); // [A-Za-z0-9_]

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w+");

//        String s1 = "abcd!?_- +=======abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\W");

//        String s1 = "poka abc Dmitry dom kino";
//        Pattern pattern1 = Pattern.compile("\\w{4}");

//        String s1 = "poka         abc              Dmitry   dom   kino";
//        Pattern pattern1 = Pattern.compile("\\w\\s+\\w");

//        String s1 = "abcd abce3 abc578abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\D{2,6}");

//        String s1 = "ABCABABABDA";
//        Pattern pattern1 = Pattern.compile("(AB){2,3}");

//        String s1 = "DABCABCDDACBCDAB";
//        Pattern pattern1 = Pattern.compile("D(AB){1,}");

//        String s1 = "DABCABCDDACBCDAB";
//        Pattern pattern1 = Pattern.compile("D(AB)*");

        String s1 = "abcd abce abc5abcg6abch";
        Pattern pattern1 = Pattern.compile("[abcd][efg3-8]");

        Matcher matcher = pattern1.matcher(s1);
        while (matcher.find()) {
            System.out.println("Position: " + matcher.start() + "  " + matcher.group());
        }
    }
}
