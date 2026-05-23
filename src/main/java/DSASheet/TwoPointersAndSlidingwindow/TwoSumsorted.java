package DSASheet.TwoPointersAndSlidingwindow;

import java.util.Arrays;

public class TwoSumsorted {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] sorted = twoSumSort(nums, target);
        System.out.println(Arrays.toString(sorted));
    }
    private static int[] twoSumSort(int[] nums, int target) {
//        for(int i=0; i<nums.length; i++) {
//            for(int j= i+ 1; j <nums.length; j++) {
//                if(nums[i] + nums[j] == target) {
//                    return new int[]{i+1, j + 1};
//                }
//            }
//        }
//        return new int[]{-1,-1};
        //optimized
        int left = 0;
        int right = nums.length - 1;
        int sum  = 0;
        while(left < right) {
            sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[] {left + 1 , right + 1};
            } else if(sum < target) {
                left++;
            } else if(sum > target) {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
