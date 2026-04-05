package MutiThreading;

public class sharedResourceofOddandEven {
    int current = 1;
    int sharedCounter;

    public sharedResourceofOddandEven(int counter) {
        this.sharedCounter = counter;
    }
    public synchronized void oddNumber() {
        while(current <= sharedCounter) {
            while(current % 2 == 0) {
                try {
                    wait();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }

            if(current<=sharedCounter) {
                current++;
                System.out.println("odd" + current);
                notifyAll();
            }
        }
    }

    public synchronized void evenNumber() {
        while(current <= sharedCounter) {
            while(current % 2 == 1) {
                try {
                    wait();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }

            if(current<=sharedCounter) {
                current++;
                System.out.println("even" + current);
                notifyAll();
            }
        }
    }
}
