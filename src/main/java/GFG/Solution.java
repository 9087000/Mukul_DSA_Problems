package GFG;

import java.util.Arrays;
import java.util.Scanner;
//step 0: Sort and set working median index
//1.sort arr in no decreasing order
//let n <- arr.length
//let start<- (n - 1) / 2
//step 1:binary search best median value
//1.intialize low<- arr[start] (current baseline of the median component)
//2. intialize high<- arr[start] +k + 1 (an exclusive upper bound)
//3. while(low+1 < high):
// .let mid<- floor((low + high)/ 2) (candidate median)
//.if(canReach(mid)) is TRUE:
// .set low<- mid(we can mid, try higher)
//.else:
//.set high<- mid (too high, go lower)
//4.when loop ends , return low as maximum achievable integer median
//step 2: Define a feasibity check
//Goal:decide if we can make the median at least x using at most  k increments
//set need<- 0 (use 64-bit accumulator)
//for every index i from start to n - 1:
//.if arr[i] < x , add(x - arr[i]) to need.
//.if the loop ends , return TRUE if need<k, need>k return FALSE
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        while(s-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int k = sc.nextInt();
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            int maxMedian = maximizeMedian(arr,k);
            System.out.println(maxMedian);
        }
    }
    public static int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int start = (n - 1) / 2;

        long low = arr[start];
        long high = arr[start] + k + 1;
        while (low + 1 < high) {
            long mid = (low + high)>>1;
            if (isCanReach(arr, start, k, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return (int) low;
    }

    private static boolean isCanReach(int[] arr, int start, int k, long target) {
        long need = 0L;
        for(int i=start; i<arr.length;i++) {
            if(arr[i]<target) {
                need += (target - arr[i]);
                if(need>k) return false;
            }
        }
        return need<=k;
    }
}
