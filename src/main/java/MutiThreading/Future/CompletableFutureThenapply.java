package MutiThreading.Future;

import java.util.concurrent.*;

public class CompletableFutureThenapply {
    //Apply to function of previous Async computation
    // creates a new completableFuture object
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {
                // Task which thread needs to executed

                return "Concept and";
            }, poolExecutor).thenApply((String val) -> {
                //functionality which runs on the result of the previous async task
                return val = "coding";
            });
            System.out.println(asyncTask.get());
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
    // it is synchronus execution
    // the same thread which works on result of previous async task
}
