package MutiThreading.threadPool;
import java.util.concurrent.*;
public class ThreadPoolExecutorMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                4,
                5,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(3),
                new CustomThreadFactory(),
                new CustomRejectedExcecution());
      threadPoolExecutor.allowCoreThreadTimeOut(true);
        for(int i=0; i<=8; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread Name:" + Thread.currentThread().getName());
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1, TimeUnit.HOURS);
    }
}

class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread th  = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        return th;
    }
}

class CustomRejectedExcecution implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task is denied:" + r.toString());
    }
}