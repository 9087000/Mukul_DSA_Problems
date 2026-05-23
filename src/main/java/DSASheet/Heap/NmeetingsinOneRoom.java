package DSASheet.Heap;

import java.util.Arrays;

public class NmeetingsinOneRoom {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        int nmeeting = nmeetingsinone(start, end);
        System.out.println(nmeeting);
    }
    static class Meeting {
        int start, end;
        public Meeting(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
    private static int nmeetingsinone(int[] start, int[] end) {
        //brute
        // Try all possible combinations
        // we Store result
        // dp[i] = max meeting we can attend ending at index i
        // Create arrays as (start, end)
        // sort by starting time
        // for each index i in n
        // dp[i] = 1
        // for each j to n - 1
        //  dp[i] = Math.max(dp[i], dp[j] + 1)
        // update max
        // answer = (max) meeting
        // T.C: o(n2)
        // S.C: o(n)
//        int n = start.length;
//
//
//        Meeting[] meetings = new Meeting[n];
//        for(int i=0; i<n; i++) {
//            meetings[i] = new Meeting(start[i], end[i]);
//        }
//        Arrays.sort(meetings, (a,b) -> a.start - b.start  );
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        int maxMeeting = 1;
//
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<i; j++) {
//                if(meetings[j].end < meetings[i].start) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//                maxMeeting = Math.max(maxMeeting, dp[i]);
//            }
//        }
//
//        return maxMeeting;

        //optimized
        // Always pick the meeting ending first
        // Earlier end -> gives maximum hours for next meeting
        // Create arrays as index(start, end)
        // sort by end time
        // pick the first meeting
        // for the i to n-1 in next meeting
        // if start > last
        // count++
        // lastend = end
        // return count
        // T.C:o(n)
        // S.C: o(1)
        int n = start.length;

        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, (a,b) -> a.end - b.end);

        int count = 1;
        int lastEnd = meetings[0].end;

        for(int i=0; i<n ;i++) {
            if(meetings[i].start>lastEnd) {
                count++;
                lastEnd = meetings[i].end;
            }
        }
        return  count;
    }
}
