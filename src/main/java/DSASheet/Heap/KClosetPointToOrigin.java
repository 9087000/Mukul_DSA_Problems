package DSASheet.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosetPointToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1,3}, {-2,2}};
        int k = 1;
        int[][] kcloset = kthCloset(points, k);
        System.out.println(Arrays.deepToString(kcloset));
    }
    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    private static int[][] kthCloset(int[][] points, int k) {
        //brute
//        Arrays.sort(points, (a,b) ->
//            (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
//        return Arrays.copyOfRange(points, 0, k);
        //optimized
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> distance(b) - distance(a));

        for(int[] point : points) {
            queue.offer(point);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[][] result = new int[k][2];

        for(int i=0; i<k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}
