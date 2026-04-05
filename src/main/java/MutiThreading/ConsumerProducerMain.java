package MutiThreading;

public class ConsumerProducerMain {
    public static void main(String[] args) {
        System.out.println("Main method start");
        SharedResource resource = new SharedResource(3);

//        Thread proucerThread = new Thread(() -> {
//            try {
//                for(int i=1; i<=6; i++) {
//                    resource.addData(i);
//                }
//            } catch (Exception e) {
//                //exception handling goes here
//            }
//        });
//
//        Thread consumerThread = new Thread(() -> {
//            try {
//                for(int i=1; i<=6; i++) {
//                    resource.consumeData();
//                }
//            } catch (Exception e) {
//                //exception goes here
//            }
//        });

        Thread proucerThread = new Thread(new ProducerTask(resource));
        Thread consumerThread = new Thread(new consumerTask(resource));

        proucerThread.start();
        consumerThread.start();
        System.out.println("Main Method end");
    }
}
