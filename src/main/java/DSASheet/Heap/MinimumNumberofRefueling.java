package DSASheet.Heap;

import java.util.PriorityQueue;

public class MinimumNumberofRefueling {
    public static void main(String[] args) {
        int target = 1;
        int startFuel = 1;
        int[][] stations = {};
        int refueling = minimumnumberofrefueling(target, startFuel, stations);
        System.out.println(refueling);
    }
    private static int minimumnumberofrefueling(int target, int startFuel, int[][] stations) {
        //brute(DP)
        // Each car has
        // target = distance to destination
        // startFuel = initial fuel
        // station[i] = [position, fuel]
        // return minimum refueling stops to reach target
        // dp[stops] = farthest distance reachable to reach target
        // pseudocode
        // initialize stations.length with n
        // create dp array with size of n + 1
        // for i from 0 to n
        // position = station[0]
        // fuel = station[1]
        // for stops i to stops>=0
        // if dp[stops] >= position
        // dp[stops + 1] = max(dp[stops + 1] , dp[stops] + fuel)
        // for stops 0 to n
        // if dp[stops] >= target
        // return stops
        // else
        // return -1;
        //T.C: o(n2)
        // S.C: o(n)
//        int n = stations.length;
//
//        long[] dp = new long[n + 1];
//
//        dp[0] = startFuel;
//        for(int i=0; i<n; i++) {
//            int position = stations[i][0];
//            int fuel = stations[i][1];
//
//            for(int stops=i; stops>=0; stops--) {
//                if (dp[stops]>= position) {
//                    dp[stops + 1] = Math.max(dp[stops + 1], dp[stops] + fuel);
//                }
//            }
//        }
//
//        for(int stops=0; stops<=n; stops++) {
//            if(dp[stops] >= target) {
//                return stops;
//            }
//        }
//
//        return -1;
        //optimized
        //Dont refuel at every station
        // Pass Reachable stations
        // store fuel in max heap
        // When it gets struck , take largest fuel from previous passed stations
        // Taking largest fuel from previous station give maximum in one stop
        // fuel = startFuel
        // stops = 0
        // index = 0
        // maxHeap intialization
        // while(fuel < target)
        // if(index < stations.length && stations[index][0] <= fuel)
        // maxHeap add with stations[index][1]
        // index++
        // if(maxHeap.isEmpty())
        // return -1
        //  fuel+=maxHeap.poll()
        // stops++
        // return stops
        // T.C : o(n)
        // S.C : o(1)
        // At any point car got struck, you need to start taking fuel from previous stations passed, take the maximum fuel from previous station passed
        // Taking maximum fuel gives maximum one stop
        int n = stations.length;

        int fuel = startFuel;
        int stops = 0;
        int index = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        while (fuel < target) {
            if (index<stations.length && stations[index][0] <= fuel) {
                maxHeap.add(stations[index][1]);
                index++;
            }
            if(maxHeap.isEmpty()) {
                return -1;
            }
            fuel+=maxHeap.poll();
            stops++;
        }

        return stops;
    }
}
