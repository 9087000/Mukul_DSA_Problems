package DSASheet.Grpahs;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        int network = networkDelayTime(times, n, k);
        System.out.println(network);
    }

    //optimized
    // PriorityQueue is used
    // Data Sturctures
    // priorityQueue
    // stores
    // distance, weight
    // distance[]
    // shortest distance from source to every node
    // distance[k] = 0
    // Relaxation
    // CurrentNode
    // |
    // neighbour
    // |
    // Edge Weight
    // current Distance
    // |
    // new Distance
    // currentDistance + weight
    // compare
    // newDistance < distance[newNode]
    // |
    // IF yes
    // |
    // update
    // |
    // push into queue
    // PriorityQueue removes shorted path first since shortest path is fixed larger path are explored
    // Build graph
    // |
    // PriorityQueue
    // |
    //  poll minimum distance
    // |
    // visit neighbour
    // |
    // Relaxation
    // |
    //  update Distance
    // |
    // push again
    // |
    //  Queue is Empty
    // |
    // Find maximum Distance
    // |
    // return answer
    // T.C : o((E + V) log v)
    // S.C : o(V + E)
    // List<List<int[]>> graph = new ArrayList<>()
    // for int i from 0 to less than n
    // graph.add(new ArrayList<>())
    // for int[] time: times
    // source = time[0]
    // dest = time[1]
    // weight = time[2]
    // graph.get(source).add(new int[]{dest, weight})
    // PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0])
    // queue.offer(new int[]{0,k})
    // int[] distance = new int[n + 1]
    // Arrays.fill(distance, Integer.MAX_VALUE)
    // distance[k] = 0
    // while(!queue.isEmpty())
    // int[] current = queue.poll()
    // int currentDistance = current[0]
    // int currentNode = current[1]
    // if currentDistance > distance[currentNode])
    // continue
    // for int[] neighbour : graph.get(currentNode))
    // int newNode = neighbour[0]
    // int weight = neighbour[1]
    // newDistance = currentDistance + weight
    // if newDistance < distance[newNode]
    // distance[newNode] = newDistance
    // queue.offer(new int[]{newDistance, newNode})
    // answer = 0
    // for int i from to less than n
    // if distance[i] == Integer.MAX_VALUE
    // return -1
    // answer = Math.max(answer, distance[i])
    // return answer
    private static int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int target = time[2];

            graph.get(source).add(new int[]{dest, target});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        queue.offer(new int[]{0, k});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int currentDistance = current[0];
            int currentNode = current[1];

            if (currentDistance > distance[currentNode]) {
                continue;
            }

                for (int[] neighbour : graph.get(currentNode)) {
                    int nextNode = neighbour[0];
                    int weight = neighbour[1];

                    int newDistance = currentDistance + weight;
                    if (newDistance < distance[nextNode]) {
                        distance[nextNode] = newDistance;
                        queue.offer(new int[]{newDistance, nextNode});
                    }
                }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, distance[i]);
        }
        return answer;
    }
}

        //brute
        // build graph
        // List<List<int[]>>
        // each node stores
        // neighbour
        // distance
        // Try
        // BFS
        // starting from source node
        // Maintain
        // current distance
        // whenever node is reached
        // update minimum
        // continue exploring BFS
        // Build graph
       // |
       // bfs
       // |
       //  visit neighbours
       // |
       //  currentDistance + weight
       //  |
       //  smaller?
       //   |
       // update minimum
       //  |
       //  run dfs again
       //  |
       //   Find maximum answer
       // Try exploring every BFS path
       // if currentDistance < stored Distance
       // update maximum answer
       // T.C: o(V *  E)
       // S.C : o(V + E)
// List<List<int[]>> graph = new ArrayList<>()
// for int i from 0 to less then equal n
// graph.add(new ArrayList<>())
// for int[] time : times
// source = time[0]
// dest = time[1]
// weight = time[2]
// graph.get(source).add(new int[]{dest, weight})
// int[] distance = new int[n + 1]
// Arrays.fill(distance, Integer.MAX_VALUE)
// dfs(graph, k, 0, distance)
// int answer = 0
// for int i from 1 to less than n
// if distance[i] == Integer.MAX_VALUE
// return -1
// answer = Math.max(answer, distance[i])
// return answer
// dfs(List<List<int[]>> graph, int currentNode, int currentDistance, int[] distance)
// if(currentDistance >= distance[currentNode])
// return
// distance[currentNode] = currentDistance
// for int[] neighbour : graph.get(currentNode))
// int newNode = neighbour[0]
// int weight = neighbour[1]
// dfs(graph, newNode, currentDistance + weight, distance)
//    private static int networkDelayTime(int[][] times, int n, int k) {
//       List<List<int[]>> graph = new ArrayList<>();
//
//       for(int i=0; i<=n; i++) {
//           graph.add(new ArrayList<>());
//       }
//
//       for(int[] time: times) {
//           int source = time[0];
//           int dist = time[1];
//           int weight = time[2];
//           graph.get(source).add(new int[]{dist, weight});
//       }
//
//       int[] distance = new int[n + 1];
//       Arrays.fill(distance, Integer.MAX_VALUE);
//       dfs(graph, k , 0, distance);
//       int answer =0;
//       for(int i=1; i<=n ; i++) {
//           if(distance[i] == Integer.MAX_VALUE) {
//               return -1;
//           }
//
//           answer = Math.max(answer, distance[i]);
//       }
//
//       return answer;
//    }
//
//    private static void dfs(List<List<int[]>> graph, int currentNode, int currentDistance, int[] distance) {
//        if(currentDistance >= distance[currentNode]) {
//            return;
//        }
//
//        distance[currentNode] = currentDistance;
//
//        for(int[] neighbour : graph.get(currentNode)) {
//            int nextNode = neighbour[0];
//            int weight = neighbour[1];
//
//            dfs(graph, nextNode, currentDistance + weight, distance);
//        }
//    }
//  }

