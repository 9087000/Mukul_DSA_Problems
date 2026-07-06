package MutiThreading.CASOperation;

import java.util.concurrent.atomic.AtomicLong;

public class atomicLongShared {
    AtomicLong atomicLong = new AtomicLong(0);

//    public void increment() {
//        atomicLong.incrementAndGet();
//    }
//    public void decrement() {
//        atomicLong.decrementAndGet();
//    }

     public void getAndIncrement() {
         atomicLong.getAndIncrement();
     }

     public void compareAndSet(int expected, int newValue) {
         atomicLong.compareAndSet(expected, newValue);
     }

    public AtomicLong get() {
        return atomicLong;
    }
}
