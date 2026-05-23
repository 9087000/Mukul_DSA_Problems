package MutiThreading;

public class extendsThread {
    public static void main(String[] args) {
        System.out.println("Going inside main method:" + Thread.currentThread().getName());
        MutiThredingLearning learning = new MutiThredingLearning();
        learning.start();
        System.out.println("Finishh main method:" + Thread.currentThread().getName());
    }
}
