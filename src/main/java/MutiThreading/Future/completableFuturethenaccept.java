package MutiThreading.Future;

import java.util.concurrent.*;

public class completableFuturethenaccept {
    // Generally the end stage in chain of async operation
    // it does not return anything
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<Void> asyncTask = CompletableFuture.supplyAsync(() -> {
                System.out.println("task which run on 'supplyAsync'" + Thread.currentThread().getName());
                return "Concept and";
            }, poolExecutor).thenAccept((String val) -> {
                System.out.println("All stages completed");
            });
            System.out.println(asyncTask.get());
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
