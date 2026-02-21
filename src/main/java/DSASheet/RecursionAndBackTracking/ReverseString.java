package DSASheet.RecursionAndBackTracking;

import java.util.Scanner;
//Step 1: Input array s of characters
//step 2:  set i = 0 (left pointer)
//step 3:  set j = s.length() - 1 (right pointer)
//step 4: while i < j:
//. a) char temp = s[i];
//. b) s[i] = s[j];
//. c) s[j] = temp;
//. d) i++;
//. e) j--;
//for-loop
//step 1: Array input s of characters
//step 2: for loop i = 0 to i < length(s) / 2:
//. a) j = length(s) - i  - 1;
//. b) char temp = s[i]
//. c) s[i] = s[j];
//. d) s[j] = temp;
//step 3: end for
public class ReverseString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        reverseString(s);
        System.out.println(s);
        System.out.println(new String(s));
    }
//    //Using while loop
//    private static void reverseString(char[] s) {
//        int i = 0, j = s.length - 1;
//        while(i<j) {
//            char temp = s[i];
//            s[i] = s[j];
//            s[j] = temp;
//            i++;
//            j--;
//        }
//    }
    //Using for loop
    private static  void reverseString(char[] s) {
        int n= s.length - 1;
        for(int i=0; i<n/2; i++) {
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
    }
}
