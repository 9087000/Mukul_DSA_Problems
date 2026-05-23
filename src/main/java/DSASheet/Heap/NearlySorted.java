package DSASheet.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySorted {
    public static void main(String[] args) {
        int[] nums = {2,3,1,4};
        int k = 2;
        nearlySorted(nums,k);
        System.out.println(Arrays.toString(nums));
    }
    private static void nearlySorted(int[] nums, int k) {
        //brute
//        Arrays.sort(nums);
        //optimized
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int index = 0;

        for(int num : nums) {
            queue.offer(num);

            if(queue.size() > k + 1) {
                nums[index++] = queue.poll();
            }
        }

        while(!queue.isEmpty()) {
            nums[index++] = queue.poll();
        }
    }
}
