package DSASheet.Heap;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int overlapping = nonOverlapping(intervals);
        System.out.println(overlapping);
    }
    private static int nonOverlapping(int[][] intervals) {
        //brute
        // Instead of trying all combinations we store result
        // we convert it to max non overlapping intervals
        //  n - maxKeep
        // Sort by start time
        // dp[i] = max number of maximum non-overlappign intervals ending at time i
        // for each i and j < i
        // if(intervals[j][1] <= interval[i][0])
        // update maxKeep with dp[i]
        // return n - maxKeep
        // T.C: o(n^2)
        // S.c: o(n)
//        int n = intervals.length;
//        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        int maxKeep = 1;
//
//        for(int i=1; i<n; i++) {
//            for(int j=0; j<i; j++) {
//                if(intervals[j][1] <= intervals[i][0]) {
//                    dp[i] = Math.max(dp[i] , dp[j] + 1);
//                }
//            }
//            maxKeep = Math.max(maxKeep, dp[i]);
//        }
//
//        return n - maxKeep;
        //optimized
        // We sort by end time , always keep the ending intervals earliest
        // because we have rooms for next intervals
        // sort by end time
        // prevEnd = previous ended interval
        // intialize removals
        // for each interval in i to n
        // if(intervals[i][0]<=prevEnd)
        // increment removal
        // else
        //  update prevEnd with interval[i][1]
        // return removal
        // T.C: o(n log n)
        // S.C: o(1)
        int n = intervals.length;

        Arrays.sort(intervals , (a,b) -> a[1]- b[1]);

        int removal = 0;
        int prevEnd = intervals[0][1];

        for(int i=1; i<n; i++) {
            if(intervals[i][0]<prevEnd) {
                removal++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return removal;

    }
}
