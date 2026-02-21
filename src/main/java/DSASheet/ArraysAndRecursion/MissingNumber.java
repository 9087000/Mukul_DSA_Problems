package DSASheet.ArraysAndRecursion;

import java.util.Scanner;
//step 0. Determine the full size
// 1. N-> LENGTH(arr) + 1
//because origin set should have size n , but one element is missing
//step 1. compute expected total
// totalSum <- N *(N + 1) / 2
//formula for sum of n natural numbers
//step 2. Compute actual sum
// arrSum -> 0
// For Each x in arr:
// arrSum -> arrSum + x
//step 3. Find Missing  element
//missing -> totalSum - arrSum
//step 4. return result
//RETURN result
public class MissingNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n --> 0) {
            int t = sc.nextInt();
            int[] arr = new int[t];
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            int num = missingNum(arr);
            System.out.println(num);
        }
    }
    public static int missingNum(int[] arr) {
        int n = arr.length + 1;
        long totalSum =  (long) n * (n + 1) / 2;

        int sum = 0;
        for(int num: arr) {
            sum += num;
        }

        return (int) (totalSum - sum);
    }
}
