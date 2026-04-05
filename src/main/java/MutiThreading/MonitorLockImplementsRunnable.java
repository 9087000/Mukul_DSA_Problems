package MutiThreading;

public class MonitorLockImplementsRunnable implements Runnable{

    MonitorLockExample obj;

    MonitorLockImplementsRunnable(MonitorLockExample obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.task1();
    }
}
