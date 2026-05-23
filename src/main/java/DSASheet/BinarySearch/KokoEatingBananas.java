package DSASheet.BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int hours = 8;
        int koko = eatingBanana(piles, hours);
        System.out.println(koko);
    }
    private static int eatingBanana(int[] piles, int hours) {
        //brute
//        int maxPile = 0;
//        for(int pile: piles) {
//            maxPile = Math.max(maxPile, pile);
//        }
//
//        for(int k=1; k<=maxPile; k++) {
//            int totalHours = 0;
//            for(int pile: piles) {
//                totalHours+= (pile + k - 1)/ k;
//            }
//
//            if(totalHours<=hours) {
//                return k;
//            }
//        }
//        return -1;
         //optimized
        int maxPile = 0;
        for(int pile: piles) {
            maxPile = Math.max(maxPile, pile);
        }
        int left = 1;
        int right = maxPile;
        int ans = maxPile;
        while(left<=right) {
                int mid = left + (right - left) / 2;

            long totalHours = 0;
            for(int pile: piles) {
                totalHours += (pile + mid - 1) / mid;
            }

            if(totalHours <= hours) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
