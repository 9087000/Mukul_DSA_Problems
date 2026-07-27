package MutiThreading.Future;

import java.util.concurrent.*;

public class CompletableFutureRunAsync {
    // CompletableFuture.runAsync() is used to execute the task asynchronusly in a separate thread
    // runAsync takes task as runnable -> return no task -> returns completableFuture<Void>
    // supplierAsync() -> takes task as callable -> return task result -> returns completable<T>
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<Void> asyncTask = CompletableFuture.runAsync(() -> {
                System.out.println("thread which runs on runAsync" + Thread.currentThread().getName());
            });
            System.out.println(asyncTask.get());
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
