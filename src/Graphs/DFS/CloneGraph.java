package Graphs.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    /*
    given a reference of a node in a connected undirected graph. return a deep copy (clone) of the graph
    each node in the graph contains a value(int) and a list(List[Node]) of its neighbors

    each node's value is the same as the node's index (1-indexed). for example, the first node with val == 1,
    the second node val == 2, and so on. the graph is represented in the test case using an adjacency list.

    an adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the
    set of neighbors of a node in the graph.

    the given node will always be the first node with val = 1. you must return the copy of the given node as a
    reference to the cloned graph.
     */

    //  note: A deep copy means actually creating a new array and copying over the values.

    private HashMap<Integer, Node> map = new HashMap<>(); // values as Node
    public Node cloneGraph(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) return null;
        if(map.containsKey(node.val)) return map.get(node.val); // ??? map hasn't been declared with anything

        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for(Node neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor));
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}