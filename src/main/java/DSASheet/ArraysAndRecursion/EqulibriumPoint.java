package DSASheet.ArraysAndRecursion;

import java.util.Scanner;
//step-0 - Compute Total Sum
//totalSum <- 0
//for each element n in arr
//totalSum -> totalSum + n;
//steps-1 - Traverse Array with running left sum
//leftSum <- 0
// For i from 0 to n -1 do:
//.rightsum <- totalSum - leftSum - arr[i]
//IF leftSum == rightSum
//Return i
//Update leftSum<-leftSum + arr[i]
//Step 2: if None found
//Aftyer loop ends, return -1
public class EqulibriumPoint {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        while(s--> 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            int point = findEqulibrium(arr);
            System.out.println(point);
        }

    }
    public static int findEqulibrium(int arr[]) {
        int n = arr.length;
        int totalSum = 0;
        for(int i=0; i<n; i++) {
            totalSum+=arr[i];
        }
        int leftSum = 0;
        for(int i=0; i<n-1;i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
