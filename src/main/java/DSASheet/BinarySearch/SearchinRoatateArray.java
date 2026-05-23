package DSASheet.BinarySearch;

public class SearchinRoatateArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int search = search(nums, target);
        System.out.println(search);
    }
    private static int search(int[] nums, int target) {
       //brute
//        int n = nums.length;
//        for(int i=0; i<n; i++) {
//            if(nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;
        //optimized
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left<=right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]) {
                if(target < nums[mid] && nums[left]<=target) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }
            else {
                if(nums[mid] < target && target<=nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
