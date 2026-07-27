package DSASheet.Grpahs;

import java.util.*;

public class ChepaestFlightWithKstops {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100}, {2,0,100}, {1,2,100}, {1,3,600}, {2,3,200}};
        int src = 0;
        int dest = 3;
        int k = 1;
        int cheapest = cheapestflightWithKStops(n, flights, src, dest, k);
        System.out.println(cheapest);
    }

    //optimized
    // normal bfs will not work due to edge
    // normal djisktra will not work due to constraints
    // use
    // dfs + stop
    // List<List<int[]>>
    // stores
    // destination
    // cost
    // distance
    // minimum cost required to reach node
    // initially
    // distance[src] = 0
    //  relaxation
    //  currentNode
    // |
    // neighbour
    // |
    // calculate
    // current cost
    // cost + price
    // if currentCost< distance[neweNode]
    // |
    // yes
    // |
    // update
    // build graph
    // |
    //  distance[]
    // |
    //  queue
    // |
    //  poll
    // |
    // stops > k
    // |
    //  return
    // |
    // visited neighbour
    // |
    // current cost
    //  |
    //  currentcost< distance[newNode]
    // |
    // update distance
    // |
    //  queue is empty
    // |
    //  push again
    // |
    // return distance[dst]
    // T.C : o(E)
    // S.C : o(V + E)
    // List<List<int[]>> graph= new ArrayList<>()
    // for int i from 0 to n
    // graph.add(new ArrayList<>())
    // for int[] flight : flights
    // from = flight[0]
    // to = flight[1]
    // price = flight[2]
    // graph.get(from).add(new int[]{to, price})
    // int[] distance = new int[n]
    // Arrays.fill(distance, Integer.MAX_VALUE)
    // distance[src] = 0
    // Queue<int[]> queue = new LinkedList<>()
    // queue.offer(new int[]{0, src, 0})
    // while !queue.isEmtpy()
    // int[] current = queue.poll()
    // stops = current[0]
    // node = current[1]
    // price = current[2]
    // if stops > k
    // continue
    // for int[] neighbour : graph.get(node)
    // newNode = neighbour[0]
    // cost = neighbour[1]
    // newCost = price + cost
    // if newCost < distance[newNode]
    // distance[newNode] = newCost
    // queue.offer(new int[]{stops + 1, newNode, newCost})
    // return distance[dst] == Integer.MAX_VALUE  ? -1: distance[dst]
    private static int cheapestflightWithKStops(int n, int[][] flights, int src, int dest, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, src, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int stops = current[0];
            int node = current[1];
            int cost = current[2];

            if(stops> k) {
                continue;
            }

            for(int[] neighbour : graph.get(node)) {
                int nextNode = neighbour[0];
                int stop = neighbour[1];

                int newcost = cost + stop;
                if(newcost < distance[nextNode]) {
                    distance[nextNode]= newcost;
                    queue.offer(new int[]{stops + 1, nextNode, newcost});
                }
            }
        }

        return distance[dest] == Integer.MAX_VALUE ? - 1 : distance[dest];
    }
    //brute
    // Try
    // BFS
    // for every node
    // stores
    // currentDistance
    // Remaining stops
    // Whenever destination reached
    // update minimum distance
    // Build graph
    // |
    //  dfs(src)
    // |
    //  remainingEdges < 0
    // |
    // return
    // |
    //  destination ?
    // |
    // update minimum distance
    // |
    // visited neighbour
    // |
    //  cost + priece
    // |
    // remainingEdge - 1
    // |
    // Run dfs again
    // |
    //  return maximum stops
    // Every dfs explore node within k stops
    // T.C : o(V^(k + 1))
    // S.C : o(V + E)
    // List<List<int[]>> graph = new ArrayList<>()
    // for int i from 0 to n
    // graph.add(new ArrayList<>())
    // for int[] flight :flights
    // from = flight[0]
    // to = flight[1]
    // price = flight[2]
    // graph.get(from).add(new int[]{to, price})
    // int[] stops = {Integer.MAX_VALUE}
    // dfs(graph, src, dest, k + 1, 0, stops)
    // return stops[0] == Integer.MAX_VALE ? -1 : stops[0]
    // dfs
    // if remainingEdges < 0
    // return
    // src == dest
    // min[0] = Math.min(min[0], currentCost)
    // return
    // currentCost > min[0]
    // return
    // for int[] neighbour : graph.get(src)
    // int newNode = neighbour[0]
    // int next = neighbour[1]
    // dfs(graph, newNode, dest, remainingEdge - 1, currentCost + next, stops)
//    private static int cheapestflightWithKStops(int n, int[][] flights, int src, int dest, int k) {
//        List<List<int[]>> graph = new ArrayList<>();
//
//        for(int i=0; i<=n ; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for(int[] flight : flights) {
//            int from = flight[0];
//            int to = flight[1];
//            int weight = flight[2];
//            graph.get(from).add(new int[]{to, weight});
//        }
//
//        int[] stops = {Integer.MAX_VALUE};
//        dfs(graph, src, dest, k + 1, 0, stops);
//        return stops[0] == Integer.MAX_VALUE ? -1 : stops[0];
//    }
//
//    private static void dfs(List<List<int[]>> graph, int src, int dest, int remainingEdges, int currentCost, int[] stops) {
//       if(remainingEdges <0) {
//           return;
//       }
//
//       if(src == dest) {
//           stops[0] = Math.min(stops[0], currentCost);
//           return;
//       }
//
//       if(currentCost>=stops[0]) {
//           return;
//       }
//
//       for(int[] neighbour: graph.get(src)) {
//           int nextNode= neighbour[0];
//           int weight = neighbour[1];
//           dfs(graph, nextNode, dest, remainingEdges - 1, currentCost + weight, stops);
//       }
//    }
}
