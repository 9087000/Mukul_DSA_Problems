package DSASheet.TwoPointersAndSlidingwindow;

import java.util.Arrays;

public class sortByParity {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        int[] value = sortBy(nums);
        System.out.println(Arrays.toString(value));
    }
    private static int[] sortBy(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            for(int j=1; j<n;j++) {
                if(nums[j] % 2 == 0 && nums[j-1] % 2 !=0) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
//        int left = 0;
//        for(int right = 0; right<nums.length; right++) {
//            if (nums[right] % 2 == 0) {
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//                left++;
//            }
//        }
//        return nums;
    }
}
