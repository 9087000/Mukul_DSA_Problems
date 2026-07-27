package MutiThreading.Future;

import java.util.concurrent.*;

public class CompletableFuturethenapplyAsync {
    //It is asynchronus execution
    // We use different thread(from 'fork-join pool' if we do not pass executors in the method) to the function
    // when multiple thenapplyAsync() method is used , ordering is not gurantee, then run concurrently
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {
                System.out.println("Thread which runs on 'supplyAsync'" + Thread.currentThread().getName());
                return "Concept and";
            }, poolExecutor).thenApplyAsync((String val) -> {
                System.out.println("Thread which runs on 'thenApplyAsync'" + Thread.currentThread().getName());
                return val + "coding";
            });
            System.out.println("thread which runs after 'AF'" + Thread.currentThread().getName());
            System.out.println(asyncTask.get());
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
