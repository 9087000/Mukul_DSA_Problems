package DSASheet.TwoPointersAndSlidingwindow;

import java.util.Arrays;

public class SqauresOfsortedArray {
    public static void main(String[] args) {
        int[] nums={-4,-1,0,3,10};
        int[] sqaure = sqaureOfSorted(nums);
        System.out.println(Arrays.toString(sqaure));
    }
    private static int[] sqaureOfSorted(int[] nums) {
//        int n = nums.length;
//        for(int i=0; i<n; i++) {
//            nums[i] *= nums[i];
//        }
//        for(int i=0;i<n; i++){
//            for(int j=i+1;j<n;j++) {
//                if(nums[i] > nums[j]) {
//                    int temp= nums[j];
//                    nums[j] = nums[i];
//                    nums[i] = temp;
//                }
//            }
//        }
//        return nums;
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length-1;
        while(left<=right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left]*nums[left];
                left++;
            } else{
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }
}
