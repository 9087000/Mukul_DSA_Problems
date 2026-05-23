package MutiThreading.locks;

public class ReentrantLockMain {
    public static void main(String args[]) {
        ReentrantLockSharedResource resource = new ReentrantLockSharedResource();

        Thread th1 = new Thread(() -> {
            resource.producer();
        });

        Thread th2 = new Thread(() -> {
            resource.producer();
        });

        th1.start();
        th2.start();


    }
}
