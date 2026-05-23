package DSASheet.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Dailytemperature {
    public static void main(String[] args) {
        int[] temp = {30,60, 90};
        int[] dailyTemp = dailyTemprature(temp);
        System.out.println(Arrays.toString(dailyTemp));
    }
    private static int[] dailyTemprature(int[] temp) {
        //brute
//        int[] result = new int[temp.length];
//
//        for(int i=0; i<temp.length; i++) {
//            for(int j=i+1; j<temp.length; j++) {
//                if(temp[j] > temp[i]) {
//                    result[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return result;
        int[] result = new int[temp.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<temp.length; i++) {
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
