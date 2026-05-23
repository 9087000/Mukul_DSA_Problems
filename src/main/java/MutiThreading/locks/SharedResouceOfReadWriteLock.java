package MutiThreading.locks;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResouceOfReadWriteLock {
    //Read lock : More than one thread can acquire read lock
    // Write lock : only one thread can acquire write lock
    boolean isAvailable = false;
    public void producer(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            System.out.println("Read lock acquired by :" + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.readLock().unlock();
            System.out.println("Read lock released by :" + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by" + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }finally {
             lock.writeLock().unlock();
             System.out.println("Write lock is released  by: " + Thread.currentThread().getName());
        }
    }
}
