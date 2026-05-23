package DSASheet.TwoPointersAndSlidingwindow;

//We will use sliding window with two pointer  variable size window
//intialize variables int left = 0, int sum = 0, int ans = Integer.MAX_VALUE
//Expand right
//for int right = 0 to k
//sum the right variables
//Shrink window while(sum>=target)
//update ans Math.min(ans, right-left+1);
//decrement left frequency variable sum-=nums[left];
//increment left
//return ans == Integer.MAX_VALUE ? 0 : ans;
public class MinimumSizeSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,4,1,2,4,3};
        int target = 7;
        int ans = minimumSize(nums, target);
        System.out.println(ans);
    }

    private static int minimumSize(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for(int right = 0; right<nums.length; right++) {
            sum+=nums[right];
            while (sum>=target) {
                ans = Math.min(ans, right-left+1);
                sum-= nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
