package MutiThreading;

public class MonitorLockExample {
    public synchronized void task1() {
        try {
            System.out.println("Inside task1");
            Thread.sleep(10000);
        } catch (Exception e) {
           //Exception handling here
        }
    }
    public void task2() {
        System.out.println("task2, but before synchronization");
        synchronized (this) {
            System.out.println("task2, inside synchronization");
        }
    }

    public void task3() {
        System.out.println("task3");
    }
}
