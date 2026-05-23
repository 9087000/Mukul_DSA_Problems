package MutiThreading.locks;

public class SemaphorelockMain {
    public static void main(String args[]) {
        SemaphoreLockSharedResource resource = new SemaphoreLockSharedResource();

        Thread th1 = new Thread(() -> {
            resource.producer();
        });

        Thread th2 = new Thread(() -> {
            resource.producer();
        });

        Thread th3 = new Thread(() -> {
            resource.producer();
        });

        Thread th4 = new Thread(() -> {
            resource.producer();
        });

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        //await() = wait()
        // signal() = notify()
    }
}
