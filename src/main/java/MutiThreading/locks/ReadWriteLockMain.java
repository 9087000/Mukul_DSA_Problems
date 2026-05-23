package MutiThreading.locks;

import MutiThreading.SharedResource;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMain {
    public static void main(String args[]) {
        SharedResouceOfReadWriteLock resource = new SharedResouceOfReadWriteLock();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread th1 = new Thread(() -> {
            resource.producer(lock);
        });

        Thread th2 = new Thread(() -> {
            resource.producer(lock);
        });

        SharedResouceOfReadWriteLock resouce1 = new SharedResouceOfReadWriteLock();

        Thread th3 = new Thread(() -> {
            resouce1.consume(lock);
        });

        th1.start();
        th2.start();
        th3.start();
    }
}
