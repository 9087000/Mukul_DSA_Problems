package MutiThreading;

public class ProducerTask implements Runnable{
    SharedResource resource;
    public ProducerTask(SharedResource sharedResource) {
        this.resource = sharedResource;
    }

    @Override
    public void  run() {
        try {
            for(int i=1; i<=6; i++) {
                resource.addData(i);
                Thread.sleep(2000l);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
