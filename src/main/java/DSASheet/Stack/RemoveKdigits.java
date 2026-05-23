package DSASheet.Stack;

import java.util.Stack;

public class RemoveKdigits {
    public static void main(String[] args) {
        String s = "10";
        int k = 2;
        String st = removeKdigits(s, k);
        System.out.println(st);
    }
    private static String removeKdigits(String s, int k) {
        //brute
//         if(k == 0) {
//             String res = trim(s);
//             return res.length() == 0 ? "0" : res;
//         }
//
//         String min = null;
//
//         for(int i=0; i<s.length(); i++) {
//             String next = s.substring(0, i) + s.substring(i + 1);
//             String candidate = removeKdigits(next, k - 1);
//
//             if(min == null || isSmaller(candidate, min)) {
//                 min = candidate;
//             }
//         }
//         return min;
        //optimized
        Stack<Character> stack = new Stack<>();
        for(char current : s.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && stack.peek() > current) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }

        while(k>0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

//    private static String trim(String s) {
//        int i =0;
//        while(i<s.length() && s.charAt(i) == '0') {
//            i++;
//        }
//        return s.substring(i);
//    }
//
//    private static boolean isSmaller(String a, String b) {
//        if(a.length() != b.length()) {
//            return a.length() < b.length();
//        }
//        return a.compareTo(b) < 0;
//    }
}
