package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinCosttomakeAllpoints {
    public static void main(String[] args) {
        int[][] edges = {{0,0}, {2,2}, {3,10}, {5,2}, {7,0}};
        int minCost = mincost(edges);
        System.out.println(minCost);
    }
    //optimized
    // generate o(v^2) edge objects
    // |
    // sort all generated edges
    // |
    // run dfs for cycle detection
    // |
    // space is o(v ^ 2) edge
    // prim's
    // dont generate edge
    // |
    // No need to explictly or store object
    // |
    // Mahateen distance when required
    // visited[current]
    // |
    // stores the current node to MST weight
    // minCost[current]
    // |
    // stores minimum cost current with mst
    // intialize current
    // |
    // Fill mincost with infinity
    // |
    // start point from 0
    // |
    // mincost to 0
    // |
    // check for every point of unvisited vertex
    // current = point
    // |
    // for every next neighbour in vertext means graph is completed
    // |
    // calculate manhaten distance
    // |
    // distance less than mincost[next]
    // |
    // update mincost[next] to distance
    // |
    // select upto v - 1 edges
    // T.C : o(v^2)
    // S.C : o(V)
    // V = points.length
    // boolean[] visited = new boolean[V]
    // int[] minCost = new int[V]
    // minCost[0] = 0
    // Arrays.fill(minCost, Integer.MAX_VALUE)
    // totalCost = 0
    // for int cost from 0 to V
    // current = -1
    // for int node from 0 to V
    // if(!visited[node] && (current == -1 || minCost[node] < minCost[current])
    // current = node
    // if current == -1 || minCost[current] == Integer.MAX_VALUE
    // return -1
    // visited[current] = true
    // totalCost+=minCost[current]
    // for int next from 0 to V
    // distance = Math.abs(point[next][0] - point[current][0]) + Math.abs(point[next][1] - point[current][1])
    // if distance < minCost[next]
    // minCost[next] = distance
    // reutrn totalCost
    private static int mincost(int[][] edges) {
        int V = edges.length;

        boolean[] visited = new boolean[V];
        int[] mindistance = new int[V];

        Arrays.fill(mindistance, Integer.MAX_VALUE);
        mindistance[0] = 0;

        int totalCost = 0;

        for(int count=0; count<V; count++) {
            int current = -1;

            for(int point=0; point<V; point++) {
                if(!visited[point] && (current == -1 || (mindistance[point] < mindistance[current]))) {
                    current = point;
                }
            }

            if(current == -1 || mindistance[current] == Integer.MAX_VALUE) {
                return -1;
            }
            visited[current] = true;
            totalCost+=mindistance[current];

            for(int next=0; next<V; next++) {
                if(!visited[next]) {
                    int distance = Math.abs(edges[current][0] - edges[next][0]) + Math.abs(edges[current][1] - edges[next][1]);
                    if(distance<mindistance[next]) {
                        mindistance[next] = distance;
                    }
                }
            }
        }
        return totalCost;
    }
    //brute
    // given a point on two dimensional Plane
    // |
    // Cost of connecting two point is manhatan distance
    // |
    //  distance = |x1- x2| + |y1-y2|
    // |
    // connect every point
    // |
    // keep connection cost minimum
    // |
    // Minimum spanning tree of graph
    // point
    // |
    // vertex
    // |
    //  every point is undirected weighted edge
    // |
    // Manhatan distance
    // |
    // represents edge weight
    // Every point can connect to every other point
    // |
    // generate all possible edge
    // |
    // start from first to second with edges
    // second starts from first + 1
    // |
    // Manhatan distance
    // |
    // add first,second, distance
    // sort all generated edges
    // in a increasing order of distance
    // |
    //  create a empty MST adjacent undirected edge
    // |
    // intialize totalEdges with V vertex
    // |
    // intilaize mincost with V vertex
    // |
    // Run dfs from source to destination using previously selected MSt
    // |
    // if source and destination already connected
    // |
    // Adding it to edge it will form a cycel
    // |
    // skip it
    // |
    // if source and destination not reachable
    // |
    // add it mincost[current] to weight
    // |
    // increment selectedEdgee
    // |
    // stop after selecting V -1
    // T.C ; o(v ^ 3 + v ^ 2 logV)
    // S.C : o(v^2)
    // V = points.length
    // List<int[]> edges = new ArrayList<>()
    // for int first from 0 to V
    // for int second from first + 1 to V
    // distance = Math.abs(point[first][0] - point[second][0]) + Math.abs(point[first][1] - point[second][1])
    // edges.add(new int[]{first, second, distance})
    // edges.sort(Comparator.comparingInt(edge -> edge[2])
    // List<List<Integer>> graph = new ArrayList<>()
    // for int i fro 0 to V
    // graph.add(new ArrayList<>())
    // int totalCost = 0;
    // int selectedEdge = 0
    // for int[] edge: edges
    // src = edge[0]
    // dest = edge[1]
    // cost = edge[2]
    // boolean[] visited = new boolean[V]
    // boolean alreadyConnected = hasalready(src, dest, graph, visited)
    // if !alreadyConnected
    // graph.get(src).add(dest)
    // graph.get(dest).add(src)
    // totalCost+=cost
    // selectedEdge++
    // if selectedEdge == V - 1
    // break
    // return selectedEdge == V - 1 ? totalCost : -1;
    // hasalready(int current, int destination, List<List<Integer>> graph, boolean[] visited)
    // if current == destination
    // return true
    // visited[current] = true
    // for int neighbour : graph.get(current)
    // if !visited[neighbour]
    // if hasAlready(neighbour, destination, graph, visited)
    // return true
    // return false
//    private static int mincost(int[][] points) {
//        List<int[]> edges = new ArrayList<>();
//
//        for(int first = 0; first<points.length; first++) {
//            for(int second = first + 1; second<points.length; second++) {
//                int distance = Math.abs(points[first][0] - points[second][0]) + Math.abs(points[first][1] - points[second][1]);
//                edges.add(new int[] {first, second, distance});
//            }
//        }
//        edges.sort(Comparator.comparingInt(edge -> edge[2]));
//        List<List<Integer>> graph = new ArrayList<>();
//
//        for(int i=0; i<points.length; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        int totalCost = 0;
//        int selectedEdge = 0;
//
//        for(int[] point : edges) {
//            int src = point[0];
//            int dest = point[1];
//            int cost = point[2];
//
//            boolean[] visited = new boolean[points.length];
//
//            boolean alreadyConnected = hasAlready(src, dest, graph, visited);
//
//            if(!alreadyConnected) {
//                graph.get(src).add(dest);
//                graph.get(dest).add(src);
//
//                totalCost += cost;
//                selectedEdge++;
//            }
//
//            if(selectedEdge == points.length) {
//                break;
//            }
//        }
//
//        return selectedEdge == points.length - 1 ? totalCost : -1;
//    }
//
//    private static boolean hasAlready(int current, int destination, List<List<Integer>> graph, boolean[] visited) {
//        if(current == destination) {
//            return true;
//        }
//
//        visited[current] = true;
//
//        for(int neighbour: graph.get(current)) {
//            if(!visited[neighbour]) {
//                if(hasAlready(neighbour, destination, graph, visited)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
}
