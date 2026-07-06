package MutiThreading.CASOperation;

public class Main {
    public static void main(String[] args) {
        //1st way
//        SharedResource resource = new SharedResource();
//
//        for(int i=0; i<400; i++) {
//            resource.increment();
//        }
//        System.out.println(resource.get());
        //2nd way
//        SharedResource resource = new SharedResource();
//
//        Thread th1 = new Thread(() -> {
//            for(int i=0; i< 200; i++) {
//                resource.increment();
//            }
//        });
//
//        Thread th2 = new Thread(() -> {
//            for(int i=0; i< 200; i++) {
//                resource.increment();
//            }
//        });
//
//        th1.start();
//        th2.start();
//
//        try {
//            th1.join();
//            th2.join();
//        } catch (Exception e) {
//
//        }
//        System.out.println(resource.get());
//
//    }
        //3rd way
//        SynchronizedSharedResource resource = new SynchronizedSharedResource();
//        AtomicIntegerSharedResource resource = new AtomicIntegerSharedResource();
//
//        Thread th1 = new Thread(() -> {
//            for (int i = 0; i < 200; i++) {
//                resource.getAndIncrement();
//                boolean first = resource.compareAndSet(0, 0);
//                System.out.println(first);
//            }
//        });
//
//        Thread th2 = new Thread(() -> {
//            for (int i = 0; i < 200; i++) {
//                resource.getAndIncrement();
//                boolean second = resource.compareAndSet(0, 0);
//                System.out.println(second);
//            }
//        });
//
//        th1.start();
//        th2.start();
//
//        try {
//            th1.join();
//            th2.join();
//        } catch (Exception e) {
//            Thread.currentThread().interrupt();
//        }
//        System.out.println(resource.get());
//    }
        //4th wat
//        AtomicIntegerBoolean resource = new AtomicIntegerBoolean();
//
//        Thread th1 = new Thread(() -> {
//            for(int i=0; i<400; i++) {
//                resource.start();
//                System.out.println("Thread-1 is running");
//            }
//        });
//
//        Thread th2 = new Thread(() -> {
//            for(int i=0; i<400; i++) {
//                resource.stop();
//                System.out.println("Thread-2 is running");
//            }
//        });
//
//        th1.start();
//        th2.start();
//
//        try {
//            th1.join();
//            th2.join();
//        } catch (Exception e) {
//            Thread.currentThread().interrupt();
//        }
//        System.out.println(resource.isRunning());

        //5th way

//        AtomicReferenceShared resource = new AtomicReferenceShared();
//
//        Thread th1 = new Thread(() -> {
//            for(int i=0; i<400; i++) {
//                resource.status();
//            }
//        });
//
//        Thread th2 = new Thread(() -> {
//           resource.updated();
//        });
//
//        th1.start();
//        th2.start();
//
//        try {
//            th1.join();
//            th2.join();
//        } catch (Exception e) {
//            Thread.currentThread().interrupt();
//        }
//        System.out.println(resource.get());

        // 6th way
        atomicLongShared resource = new atomicLongShared();

        Thread th1 = new Thread(() -> {
            resource.getAndIncrement();
            resource.compareAndSet(2, 3);
        });

        Thread th2 = new Thread(() -> {
            resource.getAndIncrement();
            resource.compareAndSet(2, 4);
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(resource.get());
    }
}
