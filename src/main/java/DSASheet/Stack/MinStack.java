package DSASheet.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    //brute
//    List<Integer> list;
//    public MinStack() {
//       list = new ArrayList<>();
//    }
//
//    public void push(int val) {
//        list.add(val);
//    }
//
//    public void pop() {
//        if(!list.isEmpty()) {
//            list.remove(list.size() - 1);
//        }
//    }
//
//    public int top() {
//      return list.get(list.size() - 1);
//    }
//
//    public int getMin() {
//        int min = Integer.MIN_VALUE;
//        for(int num : list) {
//            min = Math.min(min,num);
//        }
//        return min;
//    }

    //optimize
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val<= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack minstack = new MinStack();
        minstack.push(5);
        minstack.push(3);
        minstack.push(7);
        minstack.push(2);

        System.out.println(minstack.getMin());
        minstack.pop();
        System.out.println(minstack.getMin());
        System.out.println(minstack.top());
    }

}
