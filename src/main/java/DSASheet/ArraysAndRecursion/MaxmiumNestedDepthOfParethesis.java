package DSASheet.ArraysAndRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//step 1: Read string
//Read String s
//step 2: Intialize counters
//depth <- 0 // current open parenthesis depth
//maxDepth <- 0 // track maxmimum depth
//Step 3: Traverse character of string
//1.FOR each character ch in s:
//a.IF ch == '(' :
//depth -> depth + 1
//IF depth > maxDepth
//maxDepth <- depth
//ELSE IF ch == ')':
//depth <- depth - 1
//ELSE
//Ignore digit operations
//Step 4 Return result
//Return maxDepth
public class MaxmiumNestedDepthOfParethesis {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(maxDepth(s));

    }

    private static int maxDepth(String s) {
        int depth = 0, maxDepth = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                depth++;
                if(depth>maxDepth) maxDepth = depth;
            } else if(ch == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
}
