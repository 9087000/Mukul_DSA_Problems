package MutiThreading.Future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExampleofThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1,1 , TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // new thread will be created here and it will peform the task
        poolExecutor.submit(() -> {
            System.out.println("this the task that thread will execute");
        });
        //new thread will be created here let say thread1
        // main thread starts procession
        // Now if caller thread want to status of created thread it is completed or failed
    }
}
