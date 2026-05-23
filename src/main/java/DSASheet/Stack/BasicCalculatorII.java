package DSASheet.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        String t="3+5 /2";
        int res = basicCalculator(t);
        System.out.println(res);
    }
    private static int basicCalculator(String t) {
        //brute
//        List<Integer> number = new ArrayList<>();
//        List<Character> ops = new ArrayList<>();
//
//        int i = 0;
//        int n = t.length();
//        while(i < n) {
//            char ch = t.charAt(i);
//
//            if(ch == ' ') {
//                i++;
//                continue;
//            }
//
//            if(Character.isDigit(ch)) {
//                int num = 0;
//                while(i<n && Character.isDigit(t.charAt(i))) {
//                    num = num * 10 + (t.charAt(i) - '0');
//                    i++;
//                }
//                number.add(num);
//            } else {
//                ops.add(ch);
//                i++;
//            }
//        }
//
//        List<Integer> newNumbers = new ArrayList<>();
//        List<Character> newOps = new ArrayList<>();
//
//        newNumbers.add(number.get(0));
//
//        for(int j=0; j<ops.size(); j++) {
//            char op = ops.get(j);
//            int nextNum = number.get(j+1);
//
//            if(op == '*') {
//                int last = newNumbers.remove(newNumbers.size() - 1);
//                newNumbers.add(last * nextNum);
//            } else if(op == '/') {
//                int last = newNumbers.remove(newNumbers.size() - 1);
//                newNumbers.add(last / nextNum);
//            } else {
//                newOps.add(op);
//                newNumbers.add(nextNum);
//            }
//        }
//
//        int result = newNumbers.get(0);
//
//        for(int j=0; j<newOps.size(); j++) {
//            char op = newOps.get(j);
//            int nextNum = newNumbers.get(j+1);
//
//            if(op == '+') {
//                result+=nextNum;
//            } else if(op == '-') {
//                result -= nextNum;
//            }
//        }
//        return result;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);

            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == t.length() - 1) {
                if(sign == '+') {
                    stack.push(num);
                } else if(sign == '-') {
                    stack.push(-num);
                } else if(sign == '*') {
                    stack.push(stack.pop() * num);
                } else if(sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = ch;
                num = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()) {
            result+=stack.pop();
        }
        return result;
    }
}
