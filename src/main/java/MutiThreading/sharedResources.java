package MutiThreading;

public class sharedResources {
    boolean itemsAvailable = false;

    public synchronized void addItem() {
        itemsAvailable = true;
        System.out.println("Item added by:" + Thread.currentThread().getName() + "invoking all thread which are all waiting");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("ConsumeItem method invoked by: " + Thread.currentThread().getName());

        while(!itemsAvailable) {
            try {
                System.out.println("Thread is waitining now" + Thread.currentThread().getName());
                wait();
            } catch (Exception e) {
                //exception handling goes here
            }
        }
        System.out.println("Item consumed by: " + Thread.currentThread().getName());
        itemsAvailable = false;
    }
}
