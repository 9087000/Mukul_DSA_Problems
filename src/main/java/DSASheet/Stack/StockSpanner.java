package DSASheet.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    public static void main(String[] args) {
       StockSpanner stockSpanner = new StockSpanner();
       int[] input = {100,80,60,70,60,75,85};
       for(int price: input) {
           int result = stockSpanner.next(price);
           System.out.println("price" + price + "spoan:" + result);

       }
    }

    //brute
//    private List<Integer> prices;
//
//    public StockSpanner() {
//        prices = new ArrayList<>();
//    }
//    public int next(int price) {
//        prices.add(price);
//
//        int span = 1;
//        int i = prices.size() - 2;
//
//        while(i>=0 && prices.get(i) <= price) {
//            span++;
//            i--;
//        }
//        return span;
//    }
    //optimized
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    public int next(int price) {
        int span = 1;

        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[] {price,span});
        return span;
    }
}
