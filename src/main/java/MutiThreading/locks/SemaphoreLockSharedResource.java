package MutiThreading.locks;

import java.util.concurrent.Semaphore;

public class SemaphoreLockSharedResource {
    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);

    public void producer() {
        try {
            lock.acquire();
            System.out.println("Lock acquired by:" + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.release();
            System.out.println("Lock released by:" + Thread.currentThread().getName());
        }
    }
}
