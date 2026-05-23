package DSASheet.BinarySearch;

public class Sqrtx {
    public static void main(String[] args) {
        int x =4;
        int root = sqrt(x);
        System.out.println(root);
    }
    private static int sqrt(int x) {
        //brute
//        int ans = 0;
//        for(int i=1; i<=x; i++) {
//            if(i*i<=x) {
//                ans = i;
//            } else {
//                break;
//            }
//        }
//        return ans;

        int left = 0;
        int right = x;
        int ans = 0;

        while(left<=right) {
            int mid = left + (right - left) /2;

            if((long) mid * mid == x) return mid;

            if((long) mid * mid < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
