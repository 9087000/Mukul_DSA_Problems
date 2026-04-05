package MutiThreading;

public class MutiThredingLearning extends Thread{
    @Override
    public  void run() {
        System.out.println("Code executed by Thread:" + Thread.currentThread().getName());
        System.out.println("Code executed by Thread:" + Thread.currentThread().getName());
    }
}
