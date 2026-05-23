package DSASheet.TwoPointersAndSlidingwindow;

public class RotateArray {
    public static void main(String args[]) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotateArray(nums, k);
        System.out.println();
    }
    private static void rotateArray(int[] nums, int k) {
//        int n = nums.length;
//        k = k %n;
//        for(int i=0; i<k; i++){
//            int last = nums[n-1];
//
//            for(int j=n-1;j>0;j--) {
//                nums[j] =  nums[j-1];
//            }
//
//            nums[0] = last;
//        }

        int n = nums.length;
        k = k % n;
        reverses(nums,0, n-1);

        reverses(nums, 0, k -1);

        reverses(nums, k, n-1);
    }

    private static void reverses(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
