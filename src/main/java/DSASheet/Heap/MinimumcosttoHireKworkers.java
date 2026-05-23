package DSASheet.Heap;

import java.util.*;

public class MinimumcosttoHireKworkers {
    public static void main(String[] args) {
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        int k = 2;
        double minCost = minCosttohirekworkers(quality, wage, k);
        System.out.println(minCost);
    }
    private static double minCosttohirekworkers(int[] quality, int[] wage, int k) {
            //brute
            //Treat each worker as rate setter
            // For each worker in i
            // ratio = wage[i] / quality[i]
            // for each work in j
            // pay = quality[j] * ratio;
            // if(pay>=wage[j])
            // all qualities are valid added it to list
            //  For valid qualities size greater than k , chose the smallest qualites value
            // cost = totalQuality * ratio;
            // update the minimum answer
            // smallest cost give smallest cost
            // T.C: o(n2 log n)
            // S.C : o(n)
//        int n = quality.length;
//        double answer = Double.MAX_VALUE;
//
//        for(int i=0; i<n; i++) {
//            double rate = (double) wage[i] / quality[i];
//
//            List<Integer> validQualities = new ArrayList<>();
//            for(int j=0; j<n; j++) {
//                double pay = quality[j] * rate;
//
//                if(pay >= wage[j]){
//                    validQualities.add(quality[j]);
//                }
//            }
//
//            if(validQualities.size() >= k) {
//                Collections.sort(validQualities);
//
//                int totalQuality = 0;
//
//                for(int x=0; x<k; x++) {
//                    totalQuality+=validQualities.get(x);
//                }
//
//                double cost = totalQuality * rate;
//                answer = Math.min(answer, cost);
//            }
//        }
//        return answer;
        //Optimzied
        //Sort it by ascending ratio
        // ratio = wage[i] / quality[i];
        // So for the each worker
        // current worker ratio = group ratio
        // All workes will have smaller/ equal ratio so all are valid under this rate
        // We use maxHeap because we need k smallest qualities
        // heap to store qualities
        // if heap size exceeds k
        // remove larger qualities
        // so we keep smaller qualites
        // Create a double array :
        // [ratio, quantity]
        // for each worker in i
        // calculate ratio = wage[i]/ quality[i]
        //  sort it by ascending ratio
        // Create maxHeap of size k
        // for each worker in double array
        // add the worker to heap
        // totalQuality+=q;
        // if heap size exceeds k
        // remove largest quality
        // totalQuality-=maxHeap.poll()
        // if heap size equals k
        // cost = totalQuality * ratio
        // update min answer
        // return answer
        // T.C: o(n log n)
        // S.c: o(n)
        int n =quality.length;
        double[][] workers = new double[n][2];

        for(int i=0; i<n ;i++) {
            double ratio = (double) wage[i] / quality[i];
            workers[i][0] = ratio;
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers, (a,b) -> Double.compare(a[0] , b[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        double answer = Double.MAX_VALUE;
        int totalQuality = 0;

        for(double[] worker : workers) {
            int q = (int) worker[1];
            double ratio = worker[0];

            maxHeap.offer(q);
            totalQuality+=q;
            if(maxHeap.size()>k) {
                totalQuality-=maxHeap.poll();
            }

            if(maxHeap.size() == k) {
                double cost = totalQuality * ratio;
                answer = Math.min(answer, cost);
            }
        }

        return answer;
    }
}
