package MutiThreading.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Callable represent the task which just needs to executed like runnable
// difference
// Runnable does not return the value
// callable have a capability to return value
// runnable
// @FunctionalInterface
// public interface runnable() {
// public abstract void run()
// }
// @FunctionalInterface
// public interface callable<V>() {
// V throws exception();
// }
public class CallableAndRunnableExample {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //useCase1
        Future<?> futureObj1 = poolExecutor.submit(() -> {
                System.out.println("Task1 with runnable");
        });
        try {
            Object obj = futureObj1.get();
            System.out.println(obj == null);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        //usecase2
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj2 = poolExecutor.submit(() -> {
            output.add(100);
            System.out.println("Task2 runnable with return object");
        }, output);
        try {
            List<Integer> futureFromoutputObj2 = futureObj2.get();
            System.out.println(futureFromoutputObj2.get(0));
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        //useCase3
        Future<List<Integer>> futureObj3 = poolExecutor.submit(() -> {
            System.out.println("Task3 with callable");
            List<Integer> out = new ArrayList<>();
            out.add(100);
            return out;
        });
        try {
            List<Integer> futureFromOutputObj3 = futureObj3.get();
            System.out.println(futureFromOutputObj3.get(0));
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }
}
