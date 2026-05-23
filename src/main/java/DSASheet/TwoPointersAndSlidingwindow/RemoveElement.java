package DSASheet.TwoPointersAndSlidingwindow;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int val = 5;
        int remove= removeElement(nums, val);
        System.out.println(remove);
    }

    private static int removeElement(int[] nums, int k) {
//        int n = nums.length;
//        for(int i=0;i<n; i++) {
//            if(nums[i] == k) {
//                for (int j = i; j < n-1; j++) {
//                     nums[j] = nums[j+1];
//                }
//                n--;
//                i--;
//            }
//        }
//        return n;
        int slow = 0;
        for(int fast = 0; fast <nums.length; fast++) {
            if(nums[fast]!=k) {
                nums[fast] = nums[slow];
                slow++;
            }
        }
        return slow;
    }
}
