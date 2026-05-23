package DSASheet.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int largest = kthlargest(nums, k);
        System.out.println(largest);
    }
    private static int kthlargest(int[] nums, int k) {
        //brute
        //t.c : o(n log n)
        //s.c : o(log n) or o(1)
//        Arrays.sort(nums);
//        return nums[nums.length - k];
        //optimized
        // use min heap of size k
        //We keep only top kth largest elements
        // The smallest among top kth elements will be the kth largest element
        // create min heap of size k
        // Add each number
        // if heap.size() > k , return the smallest number
        // if heap.peek() -> return the k th largest number
        // T.c : o(n log k)
        // s.c : o(k)
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);

            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
