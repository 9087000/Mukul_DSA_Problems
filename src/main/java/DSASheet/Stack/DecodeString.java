package DSASheet.Stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

        String s = "3[a] 2[bc]";
        String decode = decodeeString(s);
        System.out.println(decode);
    }

    static int  i=0;
    public static String decodeeString(String s) {
        //brute
        i = 0;
        return helper(s);
        //optimized
//        Stack<Integer> stack = new Stack<>();
//        Stack<StringBuilder> newStack = new Stack<>();
//
//        int k = 0;
//        StringBuilder current = new StringBuilder();
//
//        for(char ch : s.toCharArray()) {
//            if(Character.isDigit(ch)) {
//                k = k * 10 + (ch - '0');
//            }
//
//            else if(ch == '[') {
//                stack.push(k);
//                newStack.push(current);
//
//                k = 0;
//                current = new StringBuilder();
//            }
//
//            else if(ch == ']') {
//                int repeat = stack.pop();
//                StringBuilder prev = newStack.pop();
//
//                for(int i=0; i<repeat; i++) {
//                    prev.append(current);
//                }
//
//                current = prev;
//            }
//
//            else {
//                current.append(ch);
//            }
//        }
//        return current.toString();
     }
     private static String helper(String s) {
        StringBuilder result = new StringBuilder();

        while(i<s.length() && s.charAt(i) != ']') {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                int num = 0;
                while (i<s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i++;
                String inner = helper(s);
                i++;
                while(num-->0) {
                    result.append(inner);
                }
            } else {
                result.append(ch);
                i++;
            }
        }
        return result.toString();
     }
}
