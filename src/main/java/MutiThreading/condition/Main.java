package MutiThreading.condition;

public class Main {
    public static void main(String args[]) {
        SharedResourceReentrantLock resource = new SharedResourceReentrantLock();

        Thread th1 = new Thread(() -> {
            for(int i=0; i<2; i++) {
                resource.proudce();
            }
        });

        Thread th2 = new Thread(() -> {
            for(int i=0; i<2; i++) {
                resource.consume();
            }
        });

        th1.start();
        th2.start();

    }
}
