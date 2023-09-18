package tregulovStreams;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int [] array = {3,8,1,5,9,12,99,7,6};
//        array = Arrays.stream(array).sorted().toArray();
//        System.out.println(Arrays.toString(array));
        int result = Arrays.stream(array).filter(e->e%2==1).map(e->{if (e%3==0) { e= e/3;} return e;
        }).reduce((a,e)-> a+e).getAsInt();
        System.out.println(result);
    }
}
