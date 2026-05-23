package DSASheet.TwoPointersAndSlidingwindow;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = mostWater(height);
        System.out.println(area);
    }
    private static int mostWater(int[] height) {
//        int area = 0;
//        for(int i=0; i<height.length; i++) {
//            for(int j=i + 1; j<height.length; j++) {
//               int  currentArea = Math.min(height[i], height[j]) * (j - i);
//               area = Math.max(area, currentArea);
//            }
//        }
//        return area;
        int left = 0;
        int right  = height.length - 1;
        int area = 0;
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(area, currentArea);

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
