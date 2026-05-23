package DSASheet.BinarySearch;

public class FindMinimumInSortedArray {
    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        int search = minimuminsortedArray(nums);
        System.out.println(search);
    }
    private static int minimuminsortedArray(int[] nums) {
        //brute
//        int n = nums.length;
//        int min = nums[0];
//        for(int i=0; i<n; i++) {
//            min=Math.min(min, nums[i]);
//        }
//        return min;
        //optimized
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left<right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return nums[left];
    }
}
