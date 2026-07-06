package MutiThreading.Future;

import java.util.concurrent.*;

// Interface which represent the result of async task
// Means it allows you to check
// computation is completed
// Get Results
// Take care of exceptions if any
public class FutureThreadExample {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.DAYS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // new thread will be created here and it will peform task
        Future<?> futureObj = poolExecutor.submit(() -> {
            System.out.println("this is task that thread will execute");
        });

        // caller thread to know the status of thread created
        System.out.println(futureObj.isDone());
    }
}
