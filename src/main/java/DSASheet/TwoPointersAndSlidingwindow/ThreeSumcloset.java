package DSASheet.TwoPointersAndSlidingwindow;

import java.util.Arrays;

public class ThreeSumcloset {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int closest = Threesumclose(nums, target);
        System.out.println(closest);
    }
    private static int Threesumclose(int[] nums, int target) {
//        int closetSum = nums[0] + nums[1] + nums[2];
//        for(int i=0; i<nums.length; i++) {
//            int sum = 0;
//            for(int j=i+1; j<nums.length; j++) {
//                for(int k=j+1; k<nums.length; k++) {
//                    sum=nums[i] + nums[j] + nums[k];
//                    if(Math.abs(target- sum) < Math.abs(target - sum)) {
//                        closetSum = sum;
//                    }
//
//                    if(sum == target) {
//                        return sum;
//                    }
//                }
//            }
//        }
//        return closetSum;
        Arrays.sort(nums);
        int closetSum = nums[0] + nums[1] + nums[2];
        for(int i=0; i<nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while(left< right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(target - sum) < Math.abs(target - closetSum)) {
                    closetSum = sum;
                }

                if(sum < target) {
                    left++;
                } else if(sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return closetSum;
    }
}
