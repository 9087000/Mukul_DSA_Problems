package MutiThreading;

public class MainThread {
    public static void main(String args[]) {
        SharedResourceOfThreadStop resource = new SharedResourceOfThreadStop();

        System.out.println("Main Thread started");
        Thread th1 = new Thread(() -> {
            System.out.println("Thread1 is using consume method");
            resource.produce();
        });
        Thread th2 = new Thread(() -> {
            try {
                Thread.sleep(1000);

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread2 is using consume method");
            resource.produce();
        });
        th1.start();
//        th2.start();
//
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            Thread.currentThread().interrupt();
//        }
        try {
            System.out.println("main Thread is waiting for thread 1 task to finish");
            th1.join();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main Thread is finishing its work");

    }
}
