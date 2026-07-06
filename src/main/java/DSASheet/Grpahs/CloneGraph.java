package DSASheet.Grpahs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public static Map<Node, Node> map = new HashMap<>();
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbours.add(node2);
        node1.neighbours.add(node4);
        node2.neighbours.add(node1);
        node2.neighbours.add(node3);
        node3.neighbours.add(node2);
        node3.neighbours.add(node4);
        node4.neighbours.add(node1);
        node4.neighbours.add(node3);

        Node clone = cloneGraph(node1);
        System.out.println("node" + clone.value);
        for(Node neighbour: clone.neighbours) {
            System.out.println(neighbour.value);
        }
    }
    //brute
    // if the input node is null return null
    // create HashMap<node,node>
    // create queue<node>
    // Create cloned node of start
    // original node -> clone node
    // Add the original node to queue
    // check if queue is not empty
    // poll the current original node
    // for each neighbour in current orginal node:
    // if the neghbour is not visited
    // create a clone
    // store in map
    // add the neighbour to queue
    // Add cloned neighbour to cloned current node neighbour list
    // return cloned node of start
    // T.C : o(V + E)
    // S.C : o(V)
    // node == null
    // return null
    // Map<Node, Node> map = new HashMap<>()
    // Queue<Node> queue = new LinkedList<>()
    // node clone = new Node(node.val)
    // map.put(node, clone)
    // queue.offer(node)
    // while !queue.isEmpty()
    // current = queue.poll
    // for node neighbour : current.neighbour
    // if(!map.containsKey(neighbour))
    // map.put(neighbour, new Node(neighbour.val)
    // queue.offer(neighbour)
    // map.get(current).neighbours.add(map.get(neighbour)
    // return clone
    private static Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node clone = new Node(node.value);

        map.put(node, clone);
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(Node neighbour: current.neighbours) {

                if(!map.containsKey(neighbour)) {
                    map.put(neighbour, new Node(neighbour.value));
                    queue.offer(neighbour);
                }
                map.get(current).neighbours.add(map.get(neighbour));
            }
        }
        return clone;
    }
    //optimized
    // if the input node is null return null
    // run the dfs on input node
    // if map contains key node // if node already exists
    // return the map contains cloned graph
    // Else create clone node
    // store
    // original node to cloned graph
    // for every neighbour in node.neighbour
    // Dfs on neighbour
    // Add cloned neighbour to current node neighbour list
    // return clone
    // T.C : o(v + E)
    // S.C : o(v)
    // Map<Node, Node> map = new HashMap<>()
    // if node == null
    // return null
    // return dfs(node)
    // dfs(node)
    // if(map.containsKey(node))
    // return map.get(node)
    // Node clone = new Node(node.val)
    // map.put(node, clone)
    // for neighbour : node.neighbours
    // clone.neighbours.add(dfs(neighbour))
    // return clone
//    private static Node cloneGraph(Node node) {
//        if(node == null) {
//            return null;
//        }
//        return dfs(node);
//    }
//    private static Node dfs(Node node) {
//        if(map.containsKey(node)) {
//            return map.get(node);
//        }
//        Node clone = new Node(node.value);
//
//        map.put(node, clone);
//
//        for(Node neighbour: node.neighbours) {
//            clone.neighbours.add(dfs(neighbour));
//        }
//        return clone;
//    }
}
