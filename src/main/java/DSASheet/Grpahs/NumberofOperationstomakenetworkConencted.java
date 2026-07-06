package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.List;

public class NumberofOperationstomakenetworkConencted {
    public static void main(String args[]) {
        int n = 6;
        int[][] operations={{0,1},{0,2},{0,3},{1,2},{1,3}};
        int numberOfoperate = numberOfOperationstomake(n, operations);
        System.out.println(numberOfoperate);
    }
    //optimized
    //  Mantain connected componets using :
    // union find
    // Every union succeds
    // component --
    // return
    // component - 1
    // if connections.lenght < n - 1
    // |
    // return - 1
    //  |
    //  initialize parent
    //  |
    //  initialize rank
    //  |
    //  for int i from 0 to n  - 1
    //  |
    //  parent[i] = i
    //  |
    //  component = n
    //  |
    //  find the parent of u
    //  |
    //  find parent of v
    //  |
    //  new parent
    //  |
    //  yes
    //  |
    //   union of parent and rank
    //   |
    //   component--
    //   |
    //  return component - 1
    //  union find keeps track of connected components
    //  Every connection beacomes
    //  Two component becomes one
    // when union succeds
    // component--
    // T.C : o(E)
    // S.C : o(V)
    // if connections.length < n - 1
    //  return - 1
    // int[] parent = new int[n]
    // int[] rank = new int[n]
    // componet = n
    // for int[] connect: connections
    // int u = connect[0]
    // int v = connect[1]
    // int parentU = find(parent, u)
    // int parentV = find(parent, v)
    // if parentU != parentV
    // union(parent, rank, parentU, parentV)
    // component--
    // return compoent  -1
    // find(parent, node)
    // if parent[node] == node
    // return node
    // parent[node] = find(parent, parent[node])
    // return parent[node]
    // union(parent, rank, u, v)
    // if(rank[u]< rank[v])
    // parent[u] = v
    // else if (rank[u] > rank[v])
    // parent[v] = u
    // else
    // parent[v] = u
    // rank[u]++
    private static int numberOfOperationstomake(int n, int[][] operations) {
        if(operations.length<n-1) {
            return -1;
        }
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        int component = n;
        for(int[] operate: operations) {
            int u = operate[0];
            int v = operate[1];
            int parentU = find(parent, u);
            int parentV = find(parent, v);
            if(parentU != parentV) {
                union(parent, rank, parentU, parentV);
                component--;
            }
        }
        return component - 1;
    }

    private static int find(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }

        parent[node] = find(parent, parent[node]);
        return parent[node];
    }

    private static void union(int[] parent, int[] rank, int u, int v) {
        if(rank[u] < rank[v]) {
            parent[u] = v;
        } else if(rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }
    //brute
    // create a adjacent list graph
    // run dfs on every unvisited node
    // count the connected component
    // required cable
    // component - 1
    // formula operations = component - 1
    //  List<List<Integer> graph
    //  |
    //  if connections.length < n - 1
    //  |
    //  yes
    //  |
    // return -1
    //  |
    //  No
    //  |
    //  boolean[] visited of size n
    //  |
    // dfs on unvisited node
    //  |
    //  component++
    //  |
    //  return componet - 1
    // T.C : o(V + E)
    // S.C : o(V + E)
    // List<List<Integer> graph = new ArrayList<>()
    // for int i from 0 to n - 1
    // graph.add(new ArrayList<>())
    // for int[] operate: operations
    // int u = operate[0]
    // int v = operate[1]
    // graph.get(u).add(v)
    // graph.get(v).add(u)
    // int component = 0
    // boolean[] visited = new boolean[n]
    // for int i from o to n - 1
    // if !visited[i]
    // dfs(graph, i, visited)
    // component++
    // return componet - 1
    // dfs(graph, current, visited):
    // visited[current] = true
    // for int neighbour : grpah.get(current)
    // if(!visited[neighbour])
    // dfs(graph, neighbour, visited)
//    private static int numberOfOperationstomake(int n, int[][] operations) {
//        List<List<Integer>> graph = new ArrayList<>();
//        for(int i=0; i<=n; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for(int[] operate : operations) {
//            int u = operate[0];
//            int v = operate[1];
//
//            graph.get(u).add(v);
//            graph.get(v).add(u);
//        }
//        boolean[] visited = new boolean[n];
//        if(operations.length < n -1) {
//            return -1;
//        }
//
//        int component = 0;
//        for(int i=0; i<n; i++) {
//            if(!visited[i]) {
//                component++;
//                dfs(graph, i, visited);
//            }
//        }
//
//        return component - 1;
//    }
//
//    private static void dfs(List<List<Integer>> graph, int current,  boolean[] visited) {
//       visited[current] = true;
//
//       for(int neighbour: graph.get(current)) {
//           if(!visited[neighbour]) {
//               dfs(graph, neighbour, visited);
//           }
//       }
//    }
}
