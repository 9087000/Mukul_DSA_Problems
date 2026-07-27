package MutiThreading.Future;

import java.util.concurrent.*;

public class CompletableFuturethenCompose {
    //chain together the dependent async operation
    // When the next async operation depends on the result of previous async task we can tie them together
    //By this asynctask we can bring some ordering
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
            CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {
                System.out.println("Task which run on 'supplyAsync'" + Thread.currentThread().getName());
                return "Concept and";
            },poolExecutor).thenCompose((String val) -> {
                return CompletableFuture.supplyAsync(() -> {
                    System.out.println("Task which run in 'thenCompose'" + Thread.currentThread().getName());
                    return val + "coding";
                });
            });
            System.out.println(asyncTask.get());
        } catch (Exception e) {
            Thread.currentThread().getName();
        }
    }
}
