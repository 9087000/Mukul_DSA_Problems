package MutiThreading;

public class sharedResouceofPingPong {
    boolean pingTurn = true;

    public synchronized void pingTurn() {
        while(!pingTurn) {
            try {
                wait();
                System.out.println("Pong is intialized"+ pingTurn);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("ping");
        pingTurn = false;
        notifyAll();
    }

    public synchronized void pongTurn() {
        while(pingTurn) {
            try {
                wait();
                System.out.println("Pong is intialized"+ pingTurn);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("pong");
        pingTurn = true;
        notifyAll();
    }
}
