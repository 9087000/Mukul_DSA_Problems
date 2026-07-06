package MutiThreading.CASOperation;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceShared {
    AtomicReference<String> ref = new AtomicReference<>("NEW");

    public void status() {
        ref.get();
    }

    public void updated() {
        ref.compareAndSet("NEW", "PROCESSED");
        System.out.println(ref.get());
    }

    public String get() {
        return ref.get();
    }
}
