package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private static final int INF = 100000000;
    public static void main(String[] args) {
        int[][] dist = {{0,4,INF, 5, INF}, {INF, 0, 1, INF, 6}, {2, INF, 0, 3, INF}, {INF, INF, 1,0, 2}, {1,INF, INF, 0, 4}};
        floydWarshall(dist);
        for(int[] row: dist) {
            System.out.println(Arrays.toString(row));
        }

    }
    //brute
    // Graph
    // |
    // weighted directed graph
    // |
    // All pairs shorted distance
    // |
    // dynamic programming
    // For Every source
    // |
    // For every destination
    // |
    //  run dfs
    // |
    // Explore every possible path
    // |
    // keep track of minimum cost
    // Build graph
    // |
    // For every source
    // |
    // For every destination
    // |
    // Dfs
    // |
    // current cost + weight
    // |
    // reached destination?
    // |
    // update answer
    // |
    // repeat
    // DFS explore
    // every possible path between source and destination
    // T.C : o(V2 * number of paths)
    // T.C: Exponential
    // S.C : o(v2 + E)
    // private static final INF = 100000000
    // int n = dist.length
    // List<List<int[]>> graph = new ArrayList<>()
    // for int i from 0 to less than n
    // graph.add(new ArrayList<>())
    // for int src from 0 to src less than n
    // for int dest from 0 to dest less than n
    // if src != dest && dist[src][dest] != INF
    // graph.get(src).add(new int[]{dest, dist[src][dest]})
    // int[][] answer = new int[n][n]
    // for int src from 0 to n
    // for int dest from 0 to n
    // if(src == dest)
    // answer[src][dest] = 0
    // continue
    // boolean[] visited = new boolean[n]
    // int[] min = {INF}
    // dfs(graph, src, dest, 0 , visited, min)
    // answer[src][dest] = min[0]
    // for int i from 0 to n
    // for int j from 0 to n
    // dist[i][j] = answer[i][j]
    // dfs
    // if src == dest
    // min[0] = Math.min(min[0], currentDistance)
    // return
    // visited[currentNode] = true
    // for int neighbour : graph.get(currentNode)
    // nextNode= neighbour[0]
    // weight = neighbour[1]
    // if !visited[neighbour]
    // dfs(graph, nextNode, dest, currentDistance + weight, visitied, min)
    // visited[currentNode] = false
    private static void floydWarshall(int[][] dist) {
        int V = dist.length;
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int src=0; src<V; src++) {
            for(int dest=0; dest<V; dest++) {
                if(dist[src][dest] !=INF && src != dest) {
                    graph.get(src).add(new int[]{dest, dist[src][dest]});
                }
            }
        }

        int[][] answer = new int[V][V];
        for(int src =0; src<V; src++) {
            for(int  dest=0; dest<V; dest++) {
                if(src == dest) {
                    answer[src][dest] = 0;
                    continue;
                }
                boolean[] visited = new boolean[V];

                int[] min = {Integer.MAX_VALUE};

                dfs(graph, src, dest, 0, visited, min);

                answer[src][dest] = min[0];
            }
        }

        for(int i=0; i<V; i++) {
            for(int j=0; j<V; j++) {
                dist[i][j] = answer[i][j];
            }
        }
    }

    private static void dfs(List<List<int[]>> graph, int currentNode, int dest, int currentDistance, boolean[] visited, int[] min) {

        if(currentNode == dest) {
            min[0] = Math.min(min[0], currentDistance);
            return;
        }

        visited[currentNode] = true;

        for(int[] neighbour : graph.get(currentNode)) {
            int nextNode = neighbour[0];
            int weight = neighbour[1];

            if(!visited[nextNode]) {
                dfs(graph, nextNode, dest, currentDistance + weight, visited, min);
            }
        }

        visited[currentNode] = false;

    }
    //optimized
    // Instead of exploring every path
    // Ask one question
    // for checking
    // i -> j
    // if
    // i->k ->j
    // can be shorter ?
    // yes
    // means then update
    // dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[j][k])
    // For every outer loop k
    // means allowed vertext k
    // to beacome intermediate vertex
    // for middle i is the
    // source
    // for inner j
    // is destination
    // Intermediate vertex (k)
    // |
    // For every source middle i
    // |
    // For every destination inner j
    // |
    // if i->k->j
    // can improve i->j
    // |
    // yes
    // |
    // update
    // T.c :o(v2)
    // S.C: o(v2)
    // After alogorithm exists
    // if dist[i][i]
    // check
    // dist[i][i] < 0
    // negative cycle exisits
    // int V = dist.length
    // for int k from 0 to n
    // for int i from 0 to n
    // for int j from 0 to n
    // if dist[i][k] != INF && dist[k][j] != INF
    // dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j])
//    private static void floydWarshall(int[][] dist) {
//        int n = dist.length;
//
//        for(int k=0; k<n; k++) {
//            for(int i=0; i<n; i++) {
//                for(int j=0; j<n; j++) {
//                    if(dist[i][k] != INF && dist[k][j] != INF) {
//                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
//                    }
//                }
//            }
//        }

//    }
}

