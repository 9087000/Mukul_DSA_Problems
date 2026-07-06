package MutiThreading.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceReentrantLock {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void proudce() {
        try {
            lock.lock();
            System.out.println("Producer thread lock acquired:" + Thread.currentThread().getName());
            if(isAvailable) {
                System.out.println("Producer thread is waiting for lock" + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
            System.out.println("Producer thread lock released:" + Thread.currentThread().getName());
        }
    }
    public void consume() {
        try {
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Consumer thread lock acquired:" + Thread.currentThread().getName());
            if(!isAvailable) {
                System.out.println("consumer thread is waiting:" + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signal();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
          lock.unlock();
          System.out.println("Consumer thread lock released:" + Thread.currentThread().getName());
        }
    }
}
