package MutiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> queue;
    private int capacity;

    public SharedResource(int bufferSize) {
        this.queue = new LinkedList<>();
        this.capacity = bufferSize;
    }

     synchronized void  addData(int item) throws InterruptedException {
        while(queue.size() == capacity)  {
            System.out.println("Buffer is full producer is waiting for consumer");
            wait();
        }
        queue.add(item);
         System.out.println("Item added by:" + item);
        notify();
    }

    synchronized int  consumeData() throws InterruptedException {
         while(queue.isEmpty()) {
             System.out.println("Buffer is empty, consumer is waiting for producer");
             wait();
         }
         int item= queue.poll();
         System.out.println("Item consumed by:" + item);
         notify();
         return item;
    }
}
