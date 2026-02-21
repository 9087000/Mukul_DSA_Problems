package DSASheet.TwoPointersAndSlidingwindow;

import java.util.*;

//1.Intialize window and answer
//.left =0 (start of current index)
//.maxLen = 0 (best answer so far)
//.right = 0
//2. Intitalize HashSet
//3.scan the string with  a right pointer
//.for right  0  to n
//let ch = s [right]
//if set.contains(c)
//. set remove left
//. left++;
//.set.add(c)
//. Compute the current window length len = right - left + ;
//.Update Answer : mxLen = max(maxLen, len)
//.right++
//4 . Return maxLen
//ABAB
//
//
public class LongestSubStringApporach2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t --> 0) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            longestSubStrings(q);
            System.out.println(q);
        }
     }
     public static void longestSubStrings(PriorityQueue<Integer> q) {
       int n = q.size();
       for(int i=0; i<n; i++) {
           for(int j=i;j<n;j++) {

           }
       }
     }
 }
