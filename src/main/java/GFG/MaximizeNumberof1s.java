package GFG;

import java.util.Scanner;
//step -0:Intialize
//1.start<- 0
//2.maxLength = 0
//3.ZerosCount = 0;
//step-1:Expand window with end
//4. for END  from 0 to n-1:
//5. if(arr[end] == 0)
//6. if (arr[end] == 0) then zerosCount <- zerosCount + 1
//step-2:Shrink if window is invalid
//7. while zerosCount > k :
//8. if arr[start] == 0 THEN zerosCount <- zerosCount - 1
//9. start -> start + 1//move edge to right
//step-3: Updated best answer
//10.maxLen <- max(maxLen, end-start + 1)
//step4- return
//Return maxLen
public class MaximizeNumberof1s {
    public static class solution {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int s = sc.nextInt();

            while (s-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                int k = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                int ones = maxOnes(arr, k);
                System.out.println(ones);
            }
        }

        public static int maxOnes(int[] arr, int k) {
            int start = 0, maxDepth = 0, zerosCount = 0;
            for (int end = 0; end < arr.length; end++) {
                if (arr[end] == 0) {
                    zerosCount++;
                }
                while (zerosCount > k) {
                    if (arr[start] == 0) {
                        zerosCount--;
                    }
                    start++;
                }
                maxDepth = Math.max(maxDepth, end - start + 1);
            }
            return maxDepth;
        }
    }
}
