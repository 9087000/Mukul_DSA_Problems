package DSASheet.RecursionAndBackTracking;

public class TrappingRain {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trapWater = trappingWater(height);
        System.out.println(trapWater);
    }
    private static int trappingWater(int[] height) {
//        int sum = 0;
//        for(int i=0; i<height.length; i++) {
//            int leftMax = 0;
//            int rightMax = 0;
//
//            for(int j=0; j<=i; j++) {
//                leftMax = Math.max(leftMax, height[j]);
//            }
//
//            for(int j=i; j<height.length; j++) {
//                rightMax = Math.max(rightMax, height[j]);
//            }
//
//            sum+=Math.min(leftMax, rightMax) - height[i];
//        }
//        return sum;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum =0;

        while(left<right) {
            if(height[left]<=height[right]) {
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum+=leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax) {
                    rightMax=height[right];
                } else {
                    sum+=rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
