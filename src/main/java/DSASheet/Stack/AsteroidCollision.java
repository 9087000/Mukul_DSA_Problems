package DSASheet.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {3,5,-2,-6};
        int[] ast = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ast));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        //brute
        List<Integer> list = new ArrayList<>();
        for (int current : asteroids) {
            list.add(current);
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < list.size() - 1; i++) {
                int first = list.get(i);
                int second = list.get(i + 1);

                if (first > 0 && second < 0) {
                    changed = true;

                    if (Math.abs(first) > Math.abs(second)) {
                        list.remove(i + 1);
                    } else if (Math.abs(first) < Math.abs(second)) {
                        list.remove(i);
                    } else {
                        list.remove(i + 1);
                        list.remove(i);
                    }
                    break;
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        //optimized
//        Stack<Integer> stack = new Stack<>();
//
//        for(int current : asteroids) {
//
//            boolean destroyed = false;
//            while(!stack.isEmpty() && stack.peek() > 0 && current < 0) {
//                int top = stack.peek();
//
//                if (top < -current) {
//                    stack.pop();
//                } else if (top == -current) {
//                    stack.pop();
//                    destroyed = true;
//                    break;
//                } else {
//                    destroyed = true;
//                    break;
//                }
//            }
//            if (!destroyed) {
//                stack.push(current);
//            }
//        }
//
//        int[] result = new int[stack.size()];
//        for(int i=result.length - 1; i>=0; i--) {
//            result[i] = stack.pop();
//        }
//        return result;
//        }
        return result;
    }
}
