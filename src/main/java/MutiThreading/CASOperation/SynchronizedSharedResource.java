package MutiThreading.CASOperation;

public class SynchronizedSharedResource {
    public int counter;

    public synchronized void increment() {
        counter++;
    }

    public int get() {
        return counter;
    }
}
