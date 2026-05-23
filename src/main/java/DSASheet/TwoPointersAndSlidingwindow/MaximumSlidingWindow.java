package DSASheet.TwoPointersAndSlidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaximumSlidingWindow {
    public static  void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = maximumWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }
    private static int[] maximumWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for(int right=0; right<n; right++) {
            int left = right - k + 1;
            if(!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);
            if(right>=k-1) {
              ans[left] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
