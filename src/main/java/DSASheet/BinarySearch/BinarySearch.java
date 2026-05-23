package DSASheet.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int search = binarySearch(nums, target);
        System.out.println(search);
    }
    private static int binarySearch(int[] nums, int target) {
        //brute
//        int n = nums.length;
//        for(int i=0; i<n; i++) {
//            if(nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;
        int left = 0;
        int right = nums.length - 1;

        while(left<= right) {
            int mid = left + (right - left) /2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
