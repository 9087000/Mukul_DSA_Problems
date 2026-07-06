package MutiThreading.CASOperation;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerSharedResource {
    AtomicInteger counter = new AtomicInteger(0);

//    public void increment() {
//        counter.incrementAndGet();
//    }
//
//    public void decrement() {
//        counter.decrementAndGet();
//    }

    public void  getAndIncrement() {
        counter.getAndIncrement();
    }

    public boolean compareAndSet(int expected, int newValue) {
       return counter.compareAndSet(expected, newValue);
    }

    public int get() {
        return counter.get();
    }
}
