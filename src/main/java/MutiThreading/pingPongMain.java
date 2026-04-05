package MutiThreading;

public class pingPongMain {
    public static void main(String args[]) {
        sharedResouceofPingPong sharedObj = new sharedResouceofPingPong();
        int n = 5;
        Thread pingThread = new Thread(() -> {
            for(int i=0; i<n; i++) {
                sharedObj.pingTurn();
            }
        });

        Thread pongThread = new Thread(() -> {
            for(int i=0; i<n; i++) {
                sharedObj.pongTurn();
            }
        });

        pingThread.start();
        pongThread.start();
    }
}
