package tregulovMultiThreading;

public class InterruptionEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        thread.join();
        System.out.println("main ends");
    }
}

class InterruptedThread extends Thread {
    double sqrtSum = 0;

    public void run() {
        for (int i = 1; i <= 1000000000; i++) {
            if (isInterrupted()) {
                System.out.println("Potok xotyat prervat");
                System.out.println("Mi ybedilis," + "" +
                        " chto sostoyanie vsex potokov normalnoe i reshili zavershit rabotu potoka");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Potok xotyat prervat vo vremya sna." +
                        "Davayte zavershim ego rabotu");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }

}
