package MutiThreading.threadPool;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactorys implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread th  = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(true);
        return th;
    }
}
