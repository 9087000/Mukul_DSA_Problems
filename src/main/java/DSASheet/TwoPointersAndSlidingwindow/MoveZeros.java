package DSASheet.TwoPointersAndSlidingwindow;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeros(nums);
    }
    private static void moveZeros(int[] nums) {
//        for(int i=0;i<nums.length; i++) {
//            for(int j=i; j<nums.length-1; j++) {
//                if(nums[j] == 0) {
//                    int temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//
//                }
//            }
//        }

        int slow = 0;
        for(int fast = 0; fast<nums.length; fast++) {
            if(nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }
}
