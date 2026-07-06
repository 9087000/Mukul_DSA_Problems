package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    public List<Node> neighbours;

    public Node() {
        value = 0;
        neighbours = new ArrayList<Node>();
    }

    public Node(int _value) {
        value = _value;
        neighbours = new ArrayList<Node>();
    }

    public Node(int _value, ArrayList<Node> neighbours) {
        value = _value;
        neighbours = neighbours;
    }
}
