package MutiThreading.locks;

public class StampedLockReadWriteMain {
    public static void main(String args[]) {
        StampedLockSharedResourceofReadWrite resource = new StampedLockSharedResourceofReadWrite();

        Thread th1 = new Thread(() -> {
            resource.producer();
        });

        Thread th2 = new Thread(() -> {
            resource.producer();
        });

        Thread th3 = new Thread(() -> {
            resource.consume();
        });

        th1.start();
        th2.start();
        th3.start();
    }
}
