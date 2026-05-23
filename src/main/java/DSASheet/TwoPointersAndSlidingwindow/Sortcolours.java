package DSASheet.TwoPointersAndSlidingwindow;

public class Sortcolours {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
    private static void sortColors(int[] nums) {
//        int c0=0, c1=0, c2=0;
//        for(int num:nums) {
//            if(num == 0) c0++;
//            else if(num == 1) c1++;
//            else c2++;
//        }
//
//        int index = 0;
//        for(int i=0; i<c0; i++) {
//            nums[index] = 0;
//            index++;
//        }
//
//        for(int i=0; i<c1; i++) {
//            nums[index] = 1;
//            index++;
//        }
//
//        for(int i=0; i<c2; i++) {
//            nums[index] = 2;
//            index++;
//        }
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
            while (mid <= high) {
                if (nums[mid] == 0) {
                     int temp = nums[low];
                     nums[low] = nums[mid];
                     nums[mid] = temp;

                     low++;
                     mid++;
                } else if(nums[mid] == 1) {
                    mid++;
                } else {
                    int temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;

                    high--;
                }
            }
    }
}
