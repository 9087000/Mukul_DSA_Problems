package MutiThreading.Future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureThencombine {
    // used to combine the two completable future
    public static void main(String[] args) {
        try {
            CompletableFuture<Integer> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("task which runs on 'supplyAsync'" + Thread.currentThread().getName());
                return 10;
            });
            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
                System.out.println("Task which runs on 'supplyAsync'" + Thread.currentThread().getName());
                return "K";
            });
            CompletableFuture<String> asyncTask = asyncTask1.thenCombine(asyncTask2, (Integer val1, String val2) -> val1 + val2);
            System.out.println(asyncTask.get());
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
