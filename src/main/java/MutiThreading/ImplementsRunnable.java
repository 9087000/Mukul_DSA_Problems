package MutiThreading;

public class ImplementsRunnable {
    public static void main(String[] args) {
        System.out.println("Goining inside Main method:" + Thread.currentThread().getName());
        MutiThreadingLearningExample runnableObj = new MutiThreadingLearningExample();
        Thread thread = new Thread(runnableObj);
        thread.start();
        System.out.println("Finish main method:" + Thread.currentThread().getName());
    }
}
