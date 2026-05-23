package MutiThreading;

public class OddandEvenMain {
    public static void main(String args[]) {
        int n = 5;
        sharedResourceofOddandEven sharedObj = new sharedResourceofOddandEven(n);

        Thread oddThread = new Thread(sharedObj::oddNumber);
        Thread evenThread = new Thread(sharedObj::evenNumber);

        oddThread.start();
        evenThread.start();
    }
}
