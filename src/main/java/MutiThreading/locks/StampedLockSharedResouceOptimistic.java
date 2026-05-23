package MutiThreading.locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockSharedResouceOptimistic {
    //support like optimistic lock functionality as well
    int a = 10;
    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Take optimistic lock in");
            a = 11;
            Thread.sleep(4000);
            if(lock.validate(stamp)) {
                System.out.println("Updated value successfully");
            } else {
                System.out.println("rollback of ours");
                a = 9;
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void consume() {
        long stamp = lock.writeLock();
        System.out.println("Write lock is acquired by:" + Thread.currentThread().getName());
        try {
            System.out.println("Performing some work");
            a = 9;
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write lock is released by:" + Thread.currentThread().getName());
        }
    }
}
