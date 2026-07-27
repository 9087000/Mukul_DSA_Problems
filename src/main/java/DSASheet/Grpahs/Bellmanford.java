package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bellmanford {
    public static void main(String[] args) {
        int v = 5;
        int[][] edge = {{1,3,2},{4,3,-1},{2,4,1},{1,2,1},{0,1,5}};
        int src = 0;
        int[] bellman = bellmanFord(v, edge, src);
        System.out.println(Arrays.toString(bellman));
    }
    //brute
    // DFS(src)
    // |
    // visit neighbour
    // |
    // currentDistance + weight
    // |
    // shorted distance reached
    // |
    //  update distance
    // why it cant solve bellman ford
    // dfs use visited ot handle infinite recursion
    // remove visited
    // |
    // infinite recursion
    // |
    // keep visited[]
    // |
    // infinite recursion
    // dfs does not explore negative edge properly
    // use dfs to reach shorted path from source and update distance
    // limitation
    // exponential time
    // does not explore negative edge properly
    // T.C : o(2^V)
    // S.C : o(V +E)
    private static int[] bellmanFord(int v, int[][] edge, int src) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<=v; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edges : edge) {
            int u = edges[0];
            int dest = edges[1];
            int weight = edges[2];

            graph.get(u).add(new int[]{dest, weight});
        }

        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[v];

        dfs(graph, src, 0, visited, distance);

        for(int i=1; i<=v-1; i++) {
            if(distance[i]==Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    private static void dfs(List<List<int[]>> graph, int src, int currentNode, boolean[] visited, int[] distance) {
        if(currentNode >= distance[src]) {
            return;
        }

        distance[src] = currentNode;
        visited[src] = true;

        for(int[] neighbour: graph.get(src)) {
            int nextNode = neighbour[0];
            int weight = neighbour[1];

            if(!visited[nextNode]){
                dfs(graph, nextNode, currentNode + weight, visited, distance);
            }
        }
        visited[src] = false;
    }
    //optimized
    // distance[]
    // |
    // repeat V - 1 times
    // |
    // Relax every edge
    // |
    // one more pass
    // |
    // negative edge
    // |
    // return distance
    // instead of exploring path
    // it relax every edge v-1 times
    // one more pass negative weighted direct graph
    // T.C: o(V * E)
    // S.C : o(V)
    // int INF = 100000000;
    // int[] distance = new int[V]
    // Arrays.fill(distance, INF)
    //distance[src] = 0
    // for int i from 1 to V - 1
    // updated = false
    // for int[] edge : edges
    // int u = edge[0]
    // v = edge[1]
    // weight = edge[2]
    // if distance[u] != INF && distance[u] + weight < distance[v]
    // distance[v] = distance[u] + weight
    // if(!updated)
    // break
    // for int[] edge :edges
    // u = edge[0]
    // v = edge[1]
    // weight = edge[2]
    // if distance[u] != INF && distance[u] + weight < distance[v]
    // return new int[]{-1}
    // return distance
//    private static int[] bellmanFord(int v, int[][] edge, int src) {
    //    int INF = 100000000;
//        int[] distance = new int[v];
//        Arrays.fill(distance, INF);
//        distance[src] = 0;
//
//        for(int i=1; i<=v; i++) {
//            boolean updated = false;
//
//            for(int[] edges :edge) {
//                int u = edges[0];
//                int dest = edges[1];
//                int weight = edges[2];
//
//                if(distance[u] != INF && distance[u] + weight < distance[dest]) {
//                        distance[dest] = distance[u] + weight;
//                        updated = true;
//                }
//            }
//
//            if(!updated) {
//                break;
//            }
//        }
//
//        for(int[] edges : edge) {
//            int u = edges[0];
//            int dest = edges[1];
//            int weight = edges[2];
//
//            if(distance[u]!= INF && distance[u] + weight < distance[dest]) {
//                return new int[]{-1};
//            }
//        }
//        return distance;
//    }
}
