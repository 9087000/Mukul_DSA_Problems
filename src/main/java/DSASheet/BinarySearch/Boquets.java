package DSASheet.BinarySearch;

public class Boquets {
    public static void main(String[] args) {
        int[] boquets = {1,10,3,10,2};
        int m = 3;
        int k = 2;
        int days = minDaysBoquets(boquets, m , k);
        System.out.println(days);
    }
    private static int minDaysBoquets(int[] boquets, int m , int k) {
        //brute
//        int n = boquets.length;
//
//        if((long) m * k > n) return -1;
//        int minDays = boquets[0];
//        int maxDays = boquets[0];
//
//        for(int boquet : boquets) {
//            minDays = Math.min(minDays, boquet);
//            maxDays = Math.max(maxDays, boquet);
//        }
//
//        for(int noOfDays=minDays; noOfDays<=maxDays; noOfDays++) {
//            int days = 0;
//            int boquet = 0;
//            for(int day : boquets) {
//                if(day<=noOfDays) {
//                    days++;
//                    if(days == k) {
//                        boquet++;
//                        days = 0;
//                    }
//                } else {
//                    days = 0;
//                }
//            }
//
//            if(boquet>=m) {
//                return noOfDays;
//            }
//        }
//        return -1;
        //optimized
        int n = boquets.length;
        int ans = 0;
        if((long) m * k > n) ans = -1;

        int minDays = boquets[0];
        int maxDays = boquets[0];

        for(int boquet: boquets) {
            minDays = Math.min(minDays, boquet);
            maxDays = Math.max(maxDays, boquet);
        }

        int left = minDays;
        int right = maxDays;

        while(left<=right) {
            int mid = left + (right - left) / 2;

            int noOfDays = 0;
            int boquet = 0;

            for(int day: boquets) {
                if(day <= mid) {
                    noOfDays++;
                    if(noOfDays == k) {
                        boquet++;
                        noOfDays = 0;
                    }
                } else {
                    noOfDays = 0;
                }
            }

            if(boquet >= m) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
