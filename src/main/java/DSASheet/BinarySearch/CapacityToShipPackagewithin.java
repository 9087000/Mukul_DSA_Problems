package DSASheet.BinarySearch;

public class CapacityToShipPackagewithin {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int capacity = capacityToShip(weights, days);
        System.out.println(capacity);
    }
    private static int capacityToShip(int[] weights, int days) {
        //brute
//        int maxWeight = 0;
//        int totalWeight = 0;
//        for(int weight : weights) {
//            maxWeight = Math.max(maxWeight, weight);
//            totalWeight+=weight;
//        }
//
//        for(int k=maxWeight; k<=totalWeight; k++) {
//           int noOfdays = 1;
//           int currentLoad = 0;
//            for(int weight : weights) {
//                if(currentLoad + weight <=k) {
//                    currentLoad+=weight;
//                } else {
//                    noOfdays++;
//                    currentLoad = weight;
//                }
//            }
//
//            if(noOfdays<=days) {
//                return k;
//            }
//        }
//        return -1;
        //optimized
        int maxWeight = 0;
        int totalWeight = 0;

        for(int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight+=weight;
        }

        int left = maxWeight;
        int right = totalWeight;
        int ans = 0;

        while(left<=right) {
            int mid = left + (right - left) / 2;

            int noOfdays = 1;
            int currentLoad = 0;
            for(int weight : weights) {
                if(currentLoad + weight <= mid) {
                    currentLoad += weight;
                } else {
                    noOfdays++;
                    currentLoad = weight;
                }
            }

            if(noOfdays<=days) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
