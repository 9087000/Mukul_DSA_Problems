package DSASheet.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementinStream {
    public static void main(String[] args) {
        KthLargestElements kthLargestElements = new KthLargestElements(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargestElements.add(3));
        System.out.println(kthLargestElements.add(5));
        System.out.println(kthLargestElements.add(10));
        System.out.println(kthLargestElements.add(9));
        System.out.println(kthLargestElements.add(4));
    }

    public static class KthLargestElements {
         //brute
        //Store all number . When new number comes
        // Add the number to the list
        // sort the list
        // return list.get(list.size() -k )
        // size-k to sorting in ascending order
        // T.c: o(n log n)
        // S.c: o(n)
//         List<Integer> list;
//         int k;
//         public KthLargestElements(int k, int[] nums) {
//             this.k = k;
//             list = new ArrayList<>();
//             for(int num: nums) {
//                 add(num);
//             }
//         }
//
//         public int add(int val) {
//             list.add(val);
//             Collections.sort(list);
//             if(list.size()<k) return -1;
//             return list.get(list.size() - k);
//         }
        //optimized
        // We need only top K largest elements not all the sorted elements
        // use min heap of size k
        // the heap stores only the current top k largest numbers
        // Among the k top largest number the smallest one is kth largest
        // minHeap.peek() == largest
        // Create min heap of size k
        // add the intial nums using add()
        // when heap.size() > k
        // add the val to heap
        // if(heap.size() > k)
        // remove the smallest heap
        // heap.peek()
        // Constructor: o(n log k)
        // add: o(log k)
        //s.c: o(k)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int k;
        public KthLargestElements(int k, int[] nums) {
            this.k = k;

            for(int num: nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.offer(val);

            if(minHeap.size() > k) {
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }
}
