package DSASheet.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStreams {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.findMedian();
        medianFinder.addNum(3);
        medianFinder.findMedian();
        System.out.println(medianFinder.findMedian());
    }

    public static class MedianFinder {
        //store as  list and when median is asked
        // sort the list
        // if it is even -> return average of middle values
        // if it is odd -> return middle
        // addNum : o(1)
        // findMedian: o(n log n)
        // S.C : o(n)
        //brute
//        ArrayList<Integer> list;
//        public MedianFinder() {
//            list = new ArrayList<>();
//        }
//
//        public void addNum(int num) {
//            list.add(num);
//        }
//
//        public double findMedian() {
//            Collections.sort(list);
//
//            int n = list.size();
//
//            if(n % 2 == 1) {
//                return list.get(n / 2);
//            } else {
//                return (list.get(n/2) + list.get(n/2 - 1)) / 2.0;
//            }
//        }
        //optimized
        //We divide into two halves
        // maxHeap - > smaller half
        // minHeap -> larger half
        // maxHeap -> we need larger value from smallest half
        // minHeap -> we need smallest value from largest half
        // maxHeap stores smaller half values
        // minHeap stores larger half values
        // maxHeap.size() == minHeap.size() or minHeap.size() = maxHeap.size() + 1
        // maxHeap can have one extra element
        // Add integer num to maxHeap
        // If it is larger move from minHeap to maxHeap
        // ensure that left half values remains smaller
        // if the minHeap is bigger , then we can we move to maxHeap
        // ensure that size is balanced
        // addNum : o(n log n)
        // findMedian : o(1)
        // space : o(n)
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a,b) -> b - a);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.offer(num);

            minHeap.offer(maxHeap.poll());

            if(minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }

            return maxHeap.peek();
        }
    }
}
