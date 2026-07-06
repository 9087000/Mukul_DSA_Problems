package MutiThreading.CASOperation;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicIntegerBoolean {
    AtomicBoolean running = new AtomicBoolean(false);

    public void  start() {
        if(running.compareAndSet(false,true)) {
            System.out.println("Started service" + Thread.currentThread().getName());
        } else {
            System.out.println("Service is already running" + Thread.currentThread().getName());
        }
    }

    public void stop() {
        if(running.compareAndSet(true, false)) {
            System.out.println("Stopped service" + Thread.currentThread().getName());
        } else {
            System.out.println("Service is already stopped" + Thread.currentThread().getName());
        }
    }

    public boolean  isRunning() {
      return running.get();
    }

}
