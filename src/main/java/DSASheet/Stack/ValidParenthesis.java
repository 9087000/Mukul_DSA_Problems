package DSASheet.Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "";
        Boolean parent = validParenthesis(s);
        System.out.println(parent);
    }
    private static boolean validParenthesis(String s) {
        //brute force
//        while(true) {
//            String reduce = s.replace("()" , "")
//                    .replace("[]", "")
//                    .replace("{}", "");
//
//            if(reduce.equals(s)) {
//                break;
//            }
//
//            s = reduce;
//        }
//        return s.isEmpty();
        //optimized
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if((ch == ')' && top != '(') || (ch == ']' && top !='[') || (ch == '}' && top!= '{')) {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
