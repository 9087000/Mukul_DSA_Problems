package DSASheet.TwoPointersAndSlidingwindow;
//We will use sliding window with two pointers
// Sliding window -> variable window -> count number of subArray
//Count number of valid subArray
// product < k
// All are positive numbers
// Product increase when window expands
// if product < k -> shrink window
// Valid window provides mutiple subArrays
//if [left... right] valid subarray window:
// = window length right
// = rihgt - left + 1
public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        int subArray = subArrayProductLessThanK(nums, k);
        System.out.println(subArray);
    }
    private static int subArrayProductLessThanK(int[] nums, int k) {
        //brute force
//        int count = 0;
//        for(int i=0; i<nums.length; i++) {
//            int product = 1;
//            for(int j=i; j<nums.length; j++) {
//                product*=nums[j];
//                if(product<k) {
//                    count++;
//                }
//            }
//        }
//        return count;
        //optimized approach
        if(k<=1) return  0;
        int left = 0;
        int prod = 1;
        int count = 0;

        for(int right = 0; right<nums.length; right++) {
            prod*=nums[right];
             while (prod>=k) {
                 prod/=nums[left];
                 left++;
            }
             count += right - left + 1;
        }
        return count;
    }
}
