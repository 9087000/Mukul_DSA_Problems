package MutiThreading.CASOperation;

public class SharedResource {
    int counter;

    public void increment() {
        counter++;
    }

    public int get() {
        return counter;
    }
}
