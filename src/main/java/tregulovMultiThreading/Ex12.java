package tregulovMultiThreading;

public class Ex12 {
static final Object object = new Object();
     void mobileCall() {
         synchronized (object) {
             System.out.println("Mobile call starts");
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("Mobile call ends");
         }
     }

     void skypeCall() {
         synchronized (object) {
             System.out.println("Skype call starts");
             try {
                 Thread.sleep(5000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("Skype call ends");
         }
     }

    void whatsappCall() {
        synchronized (object) {
            System.out.println("WhatsApp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("WhatsApp call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplSkype());
        Thread thread3 = new Thread(new RunnableImplWhatsApp());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImplMobile implements Runnable {
    public void run() {
        new Ex12().mobileCall();
    }
}

class RunnableImplSkype implements Runnable {
    public void run() {
        new Ex12().skypeCall();
    }
}

class RunnableImplWhatsApp implements Runnable {
    public void run() {
        new Ex12().whatsappCall();
    }
}