package MutiThreading;

public class ConsumerproducerTaskMain {
    public static void main(String args[]) {
        System.out.println("Main method start");
        sharedResources sharedobj = new sharedResources();

        Thread producerThread = new Thread(() -> {
            System.out.println("Producer thread is :" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000l);
            } catch (Exception e) {
                //exception handling goes here
            }
            sharedobj.addItem();
        });

        Thread consumerThread = new Thread(() -> {
            System.out.println("Consumer thread is:" + Thread.currentThread().getName());
            sharedobj.consumeItem();
        });

        producerThread.start();
        consumerThread.start();
        System.out.println("Main method end");
    }
}
