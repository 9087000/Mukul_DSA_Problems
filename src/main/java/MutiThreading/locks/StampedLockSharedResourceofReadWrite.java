package MutiThreading.locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockSharedResourceofReadWrite {
    //Support read/write lock functionality like ReadWriteLock
    boolean isAvailable = false;
    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.readLock();
        try {
            System.out.println("ReadLock is acquired by:" + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(6000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlockRead(stamp);
            System.out.println("ReadLock is released by:" + Thread.currentThread().getName());
        }
    }

    public void consume() {
        long stamp = lock.writeLock();
        try {
            System.out.println("WriteLock is acquired by:" + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("WriteLock is released by: " + Thread.currentThread().getName());
        }
    }
}
