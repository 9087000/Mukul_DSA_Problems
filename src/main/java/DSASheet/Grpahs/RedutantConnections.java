package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedutantConnections {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3}, {2,3}};
        int[] redutant = redutantConnections(edges);
        System.out.println(Arrays.toString(redutant));
    }
    //optimized
    // find ultimate parent of U
    // find the ultimate parent of V
    // if both parent are same , u and v are already conencted
    // adding edge will create cycle so return edge
    // else union them
    // why find union works
    // find maintains connected components
    // if the u and v are already connected adding edge here will creates cycle
    // find() for path comparsion + union by rank = o(alpha(N))
    // overall = o(E * alpha(N)) = o(E)
    //  parent = o(V)
    // rank = o(V)
    // overall = o(V)
    // int n = edges.length
    // int[] parent = new int[n + 1]
    // int[] rank = new int[n + 1]
    // for int i from 0 to <= edges.length
    // parent[i] = i
    // for int[] edge: edges
    // int u = edge[0]
    // int v = edge[1]
    // if((find(parent, u) == find(parent,v))
    // return edge
    // union(parent, rank, u, v)
    // return new int[0]
    // int find(int[] parent, int node):
    // if(parent[node] == node)
    // return parent[node]
    // parent[node] = find(parent, parent[node])
    // return parent[node]
    // void union(parent, rank, u,v):
    // int parentU = find(parent, u)
    // int parentV = find(parent, v)
    // if(parentU == parentV) return
    // if(rank[parentU] < rank[parentV])
    // parent[parentU] = parentV
    // else if(Rank[parentU] > parent[parentV])
    // parent[parentV] = parentU
    // else
    // parent[parentV] = parentU
    // rank[parentU]++
    // T.C : o(E)
    // S.C : o(V)
    private static int[] redutantConnections(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for(int i=0; i<=n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v= edge[1];

            if(find(parent, u) == find(parent, v)) {
                return edge;
            }
            union(parent, rank, u ,v);
        }
        return new int[0];
    }

    private static int find(int[] parent, int node) {
        if(parent[node] == node) {
            return parent[node];
        }

        parent[node] = find(parent, parent[node]);
        return parent[node];
    }
    private static void union(int[] parent, int[] rank, int u, int v) {
        int parentU = find(parent, u);
        int parentV = find(parent, v);

        if(parentU == parentV) return;

        if(rank[parentU]<rank[parentV]) {
            parent[parentU] = parentV;
        } else if(rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentV] = parentU;
            rank[parentU]++;
        }
    }
    //brute
    // pattern : graph + union find / disjoint set
    // create a graph with adjacent list
    // for every edge [u,v]:
    // Before adding edge , check if u can reach v using dfs
    // if it can reach v then both u and v are already connect and it will create cycle so return edge
    // else add u-v to edge
    // why dfs works
    // if u and v are already connected , then adding  a new edge will create cycle
    // For every edge we run dfs
    // so for dfs : o(V + E)
    // total : o(E * (V + E))
    // adjacent list : o(V + E)
    // visited array = o(v)
    // recursion stcak : o(V)
    // overall : o(v + E)
    // List<List<Integer>> graph = new ArrayList<>()
    // for int i from 0 to <= edges.length
    // graph.add(new ArrayList<>())
    // for int[] edge edges
    // int u = edge[0]
    // int v = edge[1]
    // if (dfs(graph, u, v, new boolean[edges.length + 1])
    // return edge
    // graph.get(u).add(v)
    // graph.get(v).add(u)
    // return new int[0]
    // boolean dfs(List<List<Integer>> graph, int current, int target, boolean[] visited)
    // if(current == target) return true
    // visited[current] = true
    // for int neighbour to graph.get(current))
    // if(!visited[neighbour])
    // if (dfs(graph, neighbour, target, visited))
    // return true
    // return false
    // T.C : o(v2)
    // S.c : o(V)
//    private static int[] redutantConnections(int[][] edges) {
//        List<List<Integer>> graph = new ArrayList<>();
//
//        for(int connect=0; connect<=edges.length; connect++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for(int[] edge: edges) {
//            int u = edge[0];
//            int v = edge[1];
//
//            if(dfs(graph, u, v, new boolean[edges.length + 1])) {
//                return edge;
//            }
//
//            graph.get(u).add(v);
//            graph.get(v).add(u);
//        }
//        return new int[0];
//
//    }
//
//    private static boolean dfs(List<List<Integer>> graph, int current, int target, boolean[] visited) {
//        if(current == target) return true;
//
//        visited[current] = true;
//
//        for(int neighbour: graph.get(current)) {
//            if(!visited[neighbour]) {
//                if(dfs(graph, neighbour, target, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
