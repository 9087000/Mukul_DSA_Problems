package DSASheet.BinarySearch;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        int peak = findPeakElement(nums);
        System.out.println(peak);
    }
    public static int findPeakElement(int[] nums) {
        //brute
//        int n=nums.length;
//        for(int i=0; i<n; i++) {
//            boolean left = (i==0) || nums[i] > nums[i-1];
//            boolean right = (i==n-1) || nums[i] > nums[i+1];
//
//            if(left && right) return i;
//        }
//        return -1;
        //optimized
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left<right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
