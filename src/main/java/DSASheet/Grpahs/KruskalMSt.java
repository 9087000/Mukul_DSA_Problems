package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KruskalMSt {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        int V = 3;
        int E = 3;
        int kruskal = kruskalMST(V, edges);
        System.out.println(kruskal);
    }

    //optimized
    // For every edge
    // Dfs run to check
    // source and destination are already connected
    // This run every weight MST
    // it is very Expensive
    // We use Disjoint set union also know as union-find
    // |
    // DSU maintain connected components
    // |
    // parent[node]
    // stores parent of every edge node
    // |
    // The ultimate parent node maintains the parent node of both src and destination
    // sort the edge based on weight
    // |
    // find ultimate parent of src
    // |
    // find ultimate parent of dest
    // |
    //  if source and dest is already connected
    // to same edge
    // |
    // Adding that edge to node create cycle
    // |
    // skip it
    // |
    // if source and est is connected to different component and different edge
    // |
    //  cycle will not be created
    // |
    // Add it to MST
    // |
    // Add weight to MSt weight
    // |
    // increment selected Edges
    // |
    // skip selected edge untill V - 1
    // T.C : o(E Log E)
    // S.C : o(V)
    // Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2])
    // int[] parent = new int[V]
    // int[] rank = new int[V]
    // for int node from 0 to V
    // parent[node] = node
    // int mstWeight = 0
    // int selectedEdge  =0
    // for int[] edge : edges
    // src = edge[0]
    // dest = edge[1]
    // weight = edge[2]
    // sourceParent = findParent(src, parent)
    // destParent = findParent(dest, parent)
    // if sourceParent != destParent
    // mstWeight += weight
    // selectedEdge++
    // union(src, dest, parent, rank)
    // if selectedEdge == V - 1
    // break
    // return selectedEdge == V - 1 ? mstWeight : -1
    // findParent(int node, int[] parent)
    // if parent[node] = node
    // return node
    // parent[node] = findParent(parent[node],parent)
    // return parent[node]
    // union (int src, int dest, int[] parent, int[] rank)
    // int parentU = findParent(src, parent)
    // int parentV = findParent(dest, parent)
    // if parentU == parentV return
    // if rank[parentU] < rank[parentV]
    // parent[parentU] = parentV
    // else if rank[parentU] > rank[parentV]
    // parent[parentV] = parentU
    // else
    // parent[parentV] = parentU
    // rank[parentU]++
    private static int kruskalMST(int V, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));
        int[] parent = new int[V];
        int[] rank = new int[V];

        for(int node=0; node<V; node++) {
            parent[node] = node;
        }
        int mstWeight = 0;
        int selectedEdges = 0;

        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];

            int sourceParent = findParent(src, parent);
            int destParent = findParent(dest, parent);

            if(sourceParent != destParent) {
                mstWeight+=weight;
                selectedEdges++;
                union(parent, rank, src, dest);
            }

            if(selectedEdges == V - 1) {
                break;
            }
        }

        return selectedEdges == V - 1 ? mstWeight : -1;
    }

    private static int findParent(int node, int[] parent) {
        if(parent[node] == node) {
            return node;
        }

        parent[node] = findParent(parent[node], parent);
        return parent[node];
    }

    private static void union(int[] parent, int[] rank, int u, int V) {
        int parentU = findParent(u, parent);
        int parentV = findParent(V, parent);

        if(parentU == parentV) return;

        if(rank[parentU] < rank[parentV]) {
            parent[parentU] = parentV;
        } else if(rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentV] = parentU;
            rank[parentU]++;
        }
    }
    //brute
    // minimum spanning Tree
    // |
    // undirected weighted graph
    // |
    // Connect all vertices
    // |
    // Exactly V - 1 vertices
    // |
    // No cycle
    // |
    // Find minimum total edge weight
    // kruskal
    // |
    // do not start from any particular vertex
    // |
    // sort all the edge based on weight
    // |
    // process edges from minimum to maximum
    // |
    // mstWeight
    // find minimum weight edge
    // Run dfs once from source
    // check if destination can be reached
    // |
    // if source and destination is reachable
    // means source and destination already connected
    // |
    // Add the edge to node will form cycle
    // |
    // so if src and destination connected
    // |
    // skip it
    // |
    // if source and destination are not reachable and not connected
    // |
    // Add it to MST
    // |
    // stop after selecting v-1 vertex or edge
    // All edges will have V vertex
    // it selects upto v - 1 edges
    // |
    // fewer than v-1 edges means does not form cycle will add it to MST
    // |
    // larger than v-1 edges means form cycle do not add skip it
    // sort all edges based on weight
    // |
    // Build adjacent list undirected
    // |
    // find minimunm weighted edge
    // run dfs from source
    // check if destination reachable
    // |
    // if source and destination reachable
    // source and destination is already connected
    // |
    // Adding it to MST form a cycle
    // |
    //  so skip it
    // |
    // if source and destination is not connected
    // |
    // Add it to MST
    // |
    // add weight to mst weight
    // |
    // increment selected edge
    // |
    // select untill V -1 edge
    // |
    // return -1
    // T.C : o(E log E + E * (V + E)
    // S.C : o(V + E)
    // Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]))
    // List<List<Integer>> graph = new ArrayList<>()
    // for int i from 0 to V
    // graph.add(new ArrayList<>())
    // mstWeight =0
    // selectedEdges = 0
    // for int[] edge : edges
    // src = edge[0]
    // dest = edge[1]
    // weight = edge[2]
    // boolean[] visited = new boolean[V]
    // boolean alreadyConnected = hasAlread(src, dest, graph, visited)
    // if(!alreadyConnected)
    // graph.get(src).add(dest)
    // graph.get(dest).add(src)
    // mstWeight+=weight
    // selectedEdges++
    // if selectedEdges == V - 1
    // break
    // return selectedEdges == V - 1 ? mstWeight : -1
    // boolean hasAlread(int current, int destination , List<List<Integer>> graph, boolean[] visited)
    // if current == destination
    // return true
    // visited[current] = true
    // for int neighbour : graph.get(current)
    // if !visited[neighbpur]
    // if hasAlready(neighbour, destination, graph, visited)
    // return true
    // return false
//    private static int kruskalMST(int V, int[][] edges) {
//        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));
//
//        List<List<Integer>> graph = new ArrayList<>();
//
//        for (int i = 0; i < V; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        int mstWeight = 0;
//        int selectedEdges = 0;
//
//        for (int[] edge : edges) {
//            int src = edge[0];
//            int dest = edge[1];
//            int weight = edge[2];
//
//            boolean[] visited = new boolean[V];
//            boolean vist = hasAlready(src, dest, graph, visited);
//
//            if (!vist) {
//                graph.get(src).add(dest);
//                graph.get(dest).add(src);
//
//                mstWeight += weight;
//                selectedEdges++;
//            }
//
//            if (selectedEdges == V - 1) {
//                break;
//            }
//        }
//
//        return selectedEdges == V - 1 ? mstWeight : -1;
//    }
//
//    private static boolean hasAlready(int current, int destination, List<List<Integer>> graph, boolean[] visited) {
//        if (current == destination) {
//            return true;
//        }
//
//        visited[current] = true;
//        for (int neighbour : graph.get(current)) {
//            if (!visited[neighbour]) {
//                if (hasAlready(neighbour, destination, graph, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
