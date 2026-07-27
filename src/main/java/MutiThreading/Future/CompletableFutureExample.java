package MutiThreading.Future;

import java.util.concurrent.*;

public class CompletableFutureExample {
//    public static<T> completableFuture<T> supplyAsync(Supplier<T> supplier)
    // public static<T> completableFuture<T> supplierAsync(Supplier<T> supplier, Executors executor)
    // introduced in java 8
    // helps in async programming
    // We can consider it as advanced version of future provides additional capability like chaining
    // supply async initiate the async operations
    // supply method executed asynchronosly in a separate thread
    // if we want more control of threads we can pass executors in the method
    // by default it uses shared fork join pool executor it adjust it size dynamically based on processors
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<String> aysncTask1=CompletableFuture.supplyAsync(() -> {
            // this is task that thread needs to get it completed
            return "task completed";
        }, poolExecutor);

        try {
            System.out.println(aysncTask1.get());
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
