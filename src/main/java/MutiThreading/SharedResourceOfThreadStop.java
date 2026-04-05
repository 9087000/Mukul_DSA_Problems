package MutiThreading;

public class SharedResourceOfThreadStop {
    boolean isItemsAvailable = false;

    public synchronized  void  produce() {
        System.out.println("Lock is acquired");
        isItemsAvailable = true;

        try {
            Thread.sleep(8000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Lock is released");

    }
}
