package MutiThreading;

public class consumerTask implements Runnable {
    SharedResource resource;
    public consumerTask(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("Consumer thread:" + Thread.currentThread().getName());
        try {
            for(int i=1; i<=6; i++) {
                resource.consumeData();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
