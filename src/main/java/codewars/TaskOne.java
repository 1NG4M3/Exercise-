package codewars;

public class TaskOne {


   /* If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

    Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in. Additionally, if the number is negative, return 0 (for languages that do have them).

    Note: If the number is a multiple of both 3 and 5, only count it once.
    */

    public static int solution (int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sum += i;
            } else if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 25;
        int c = 99;
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
    }
}
