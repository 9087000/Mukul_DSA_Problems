package MutiThreading.Future;

import java.util.concurrent.*;

public class FutureThreadMethodsExamples {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //new thread will created here it will be allowed to perform the task
        Future<?> futureObj = poolExecutor.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("this is task that thread will execute");
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });


        System.out.println("isDone" + futureObj.isDone());

        try {
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Timeout Exception happened");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        try {
            futureObj.get();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("isDone" + futureObj.isDone());
        System.out.println("isCancel" + futureObj.isCancelled());
    }
}
