package DSASheet.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

public class GraphColouring {
    public static void main(String[] args) {
        int v = 4;
        int[][] edges = {{0,1}, {1,3}, {2,3}, {3,0}, {0,2}};
        int m = 3;

        boolean  colour = graphColor(v, edges, m);
        System.out.println(colour);
    }

    //optimized
    // Use Adjacent Matrix
    // List<List<Integer>> adj
    // for every edge
    // adj.get(u).add(v)
    // adj.get(v).add(u)
    // Try start recursion same way
    // solve(0, adj, color, m , v)
    // solve (index, adj, color, m, v):
    // if(index == v)
    // return true
    // Try all colors same way
    // for int c=1; c<=m; c++
    // optimized isSafe
    // instead of checking all nodes
    // check the actual neighbour nodes
    // for(int neighbour: adj.get(node))
    // place, recurse, backtrack
    // color[index] = c
    // solve(i+1, adj, color, m , v)
    // color[index] = 0
    // T.C : o(v * m^V)
    // S.C : o(v + e)
    // List<List<Integer>> adj = new ArrayList<>();
    // for(int i=0; i<v; i++) :
    // adj.add(new ArrayList<>());
    // for(int edge: edges)
    // u = edge[0]
    // v = edge[1]
    // adj.get(u).add(v)
    // adj.get(v).add(u)
    // int[] color = new int[v]
    // return solve(0, adj, color, m , n)
    // solve(int index, List<List<Integer>> adj, int[] color, int m, int n) :
    // if(index == v)
    // return true
    // for(int c=1; c<=m ; c++)
    // if(isSafe(0, adj, color, c)
    // color[index] = c
    // solve(index + 1, adj, color, m , n)
    // color[index] = 0
    // return false
    // isSafe(index, adj, color, c) :
    // for(int neighbour: adj.get(index))
    // if(color[neighbour] == c)
    // return false
    // return true
    private static boolean graphColor(int v, int[][] edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int node = edge[1];

            adj.get(u).add(node);
            adj.get(node).add(u);
        }

        int[] color = new int[v];

        return solve(0, adj, color, m, v);
    }
    private static boolean solve(int node, List<List<Integer>> adj, int[] color, int m, int v) {
        if(node == v) {
            return true;
        }

        for(int colors =1; colors<=m; colors++) {
            if(isSafe(node, adj, color, colors)) {
                color[node] = colors;

                if(solve(node+1, adj, color, m, v)) {
                    return true;
                }

                color[node] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int node, List<List<Integer>> adj, int[] color, int colors) {
        for(int neighbour : adj.get(node)) {
            if(color[neighbour] == colors) {
                return false;
            }
        }
        return true;
    }
    //brute
    //create color array with size of V
    // create a adjacentMatrix
    // boolean[][] edge = new boolean[v][v]
    // edge[0][1] = true
    // edge[1][0] = true
    // Recurse or start Recursion
    // solve(0, edge, color, m , n)
    // solve(int index, boolean[][] edge, int[] color, int m, int n) :
    // Base condition:
    // if (index == n)
    // return true
    // Try all colours
    // for(int c=1; c<=m; c++)
    // try all colours from 1 to m
    // check whether graph node isSafe to be coloured
    // if(isSafe(0, edge, color, c, m, v)
    // place
    // colors[c] = c
    // recurse
    // solve(index + 1, edge, color, m , n)
    // backtrack
    // color[c] = 0
    // isSafe(int index,boolean[][] edge, int[] color, int c, int m, int n) :
    // if(edge[index][i] && color[i] = c)
    // return false
    // return true
    //  T.C : (v * m^v)
    // S.C : o(v2)
    // n = v
    // color[] = new int[n]
    // boolean[][] edge = new boolean[n][n]
    // for(int[] edge : edges)
    // edge[e[0]][e[1]] = true
    // edge[e[1]][e[0]] = true
    // return solve(0, edge, color, m , n)
    // solve(int index, boolean[][] edge, int[] color, int m, int n) :
    // if(index == n)
    // return true
    // for(int c=1; c<=m ; c++)
    // if(isSafe(0, edge, color, c, m, n):
    // color[index] = c
    // solve(index +1, edge, color, m, n)
    // color[index] = 0
    // return false
    // isSafe(node, edge, color, c, m, n) :
    // for int i =0; i <n; i++
    // if(edge[node][i] && color[i] == c)
    // return false
    // return true
//    private static boolean graphColor(int v, int[][] edges, int m) {
//        int n =v;
//        int[] color = new int[n];
//        boolean[][] edge = new boolean[n][n];
//
//        for (int[] e: edges) {
//            edge[e[0]][e[1]] = true;
//            edge[e[1]][e[0]] = true;
//        }
//
//        return solve(0, edge, color, m, n);
//    }
//    private static boolean solve(int node, boolean[][] edges, int[] color, int m, int n) {
//        if(node == n) {
//            return true;
//        }
//
//        for(int colors = 1; colors<=m; colors++) {
//            if(isSafe(node, edges, color, colors, m, n)) {
//                color[node] = colors;
//
//                if(solve(node + 1, edges, color, m, n)) {
//                    return true;
//                }
//
//                color[node] = 0;
//            }
//        }
//
//        return false;
//    }
//
//    private static boolean isSafe(int node, boolean[][] edges, int[] color, int colors, int m, int n) {
//        for(int i=0; i<n; i++) {
//            if(edges[node][i] && color[i] == colors) {
//                return false;
//            }
//        }
//        return true;
//    }
}
