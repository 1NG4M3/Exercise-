package codewars;

import java.util.Arrays;

public class TaskTwo {
    /* In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". Your function receives one side
    of the DNA (string, except for Haskell); you need to return the other complementary side. DNA strand is never empty
    or there is no DNA at all (again, except for Haskell).
    "ATTGC" --> "TAACG"
    "GTAT" --> "CATA"
    */


    public static String makeComplement(String dna) {
        char[] chars = dna.toCharArray();
        int i = 0;
        for (char chr : chars) {
            if (chr == 'A')
                chars[i] = 'T';
            else if (chr == 'T') {
                chars[i] = 'A';

            } else if (chr == 'C') {
                chars[i] = 'G';


            } else if (chr == 'G') {
                chars[i] = 'C';
            }
            i++;

        }
        String str = new String(chars);
        return str;
    }

    public static void main(String[] args) {
        String str = makeComplement("ATTGC");
        System.out.println(str);

    }
}
