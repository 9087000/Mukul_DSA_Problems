package MutiThreading.locks;

public class StampedLockOptimisticMain {
    public static void main(String args[]) {
        StampedLockSharedResouceOptimistic resouceOptimistic = new StampedLockSharedResouceOptimistic();

        Thread th1 = new Thread(() -> {
            resouceOptimistic.producer();
        });

        Thread th2 = new Thread(() -> {
            resouceOptimistic.consume();
        });

        th1.start();
        th2.start();

    }
}
