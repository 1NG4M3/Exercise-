package someTraining;

public class Flats {

    public static int sumFlats(int m,int x, int n) {
        int sumFirstTenFlats = x * m;
        int sumSecondTenFlats = (x + n) * m;
        int sumThirdTenFlats = (x + (n*2))* m;

        return sumSecondTenFlats  + sumThirdTenFlats  + sumFirstTenFlats;
    }

    public static void main(String[] args) {
        System.out.println(sumFlats(10,10000,1000));
    }
}
