package DSASheet.TwoPointersAndSlidingwindow;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int duplicate = removeDuplicatesFromsorted(nums);
        System.out.println(duplicate);
    }
    private static int removeDuplicatesFromsorted(int[] nums) {
//        int n = nums.length;
//        for(int i=0; i<n-2; i++) {
//            if(nums[i] == nums[i+2]) {
//                for(int j=i+2; j<n-1; j++) {
//                    nums[j] = nums[j+1];
//                }
//                n--;
//                i--;
//            }
//        }
//        return n;
        int slow = 2;
        for(int fast=2; fast<nums.length; fast++) {
            if(nums[fast] != nums[slow-2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
   }
}
