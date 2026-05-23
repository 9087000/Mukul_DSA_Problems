package DSASheet.Heap;

public class GasStation {
    public static void main(String[] args) {
        int[] gas= {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int start = gasStation(gas,cost);
        System.out.println(start);
    }
    private static int gasStation(int[] gas, int[] cost) {
        //brute
//        int n = gas.length;
//
//        for(int start=0; start<n; start++) {
//            int tank = 0;
//            int step =0;
//            for(;step<n; step++) {
//                int idx = (start + step) % n;
//
//                tank += gas[idx] - cost[idx];
//
//                if(tank < 0) {
//                    break;
//                }
//            }
//            if(step==n) {
//                return start;
//            }
//        }
//
//        return -1;
        //optimized
        int n = gas.length;

        int total = 0;
        int tank = 0;
        int start = 0;

        for(int i=0; i<n; i++) {
            int diff = gas[i] - cost[i];

            tank+=diff;
            total+=diff;

            if(tank<0) {
                start = i + 1;
                tank = 0;
            }
        }

        if(total>=0) {
            return start;
        } else {
            return -1;
        }
    }
}
