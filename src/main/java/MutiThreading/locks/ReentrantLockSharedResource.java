package MutiThreading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSharedResource {
   boolean isAvailable = false;
   ReentrantLock lock = new ReentrantLock();

   public void producer() {
       try {
           lock.lock();
           System.out.println("Lock is acquired by:"+ Thread.currentThread().getName());
           isAvailable = true;
           Thread.sleep(4000);
       } catch (Exception e) {
           Thread.currentThread().interrupt();
       } finally {
           lock.unlock();
           System.out.println("Lock is relased by:" + Thread.currentThread().getName());
       }
   }
}
