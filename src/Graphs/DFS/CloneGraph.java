package Graphs.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// solution: https://www.youtube.com/watch?v=mQeF6bN8hMk&ab_channel=NeetCode
//https://www.youtube.com/watch?v=e5tNvT1iUXs&ab_channel=MichaelMuinos better explanation
//https://leetcode.com/problems/clone-graph/
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

    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>(); // values as Node
        return clone(node, map);
    }

    private Node clone(Node node, HashMap<Integer, Node> map) {
        if (node == null) return null;
        if(map.containsKey(node.val)) return map.get(node.val); // first thing we want to do is we want to check if
        // the node.val is already in our map, if it's already in our map, we do not need to visit that node again

        //if we got to this line, that tells us we do not have a copied node for this specific value and we
        // need to create it
        Node copy = new Node(node.val);
        map.put(copy.val, copy); // copy.val is same as node.val, can use either
        for(Node neighbor : node.neighbors) // looping over all ours neighbors
            copy.neighbors.add(clone(neighbor, map)); //we access our neighbors with .neighbors,
            // then we add in the recursive call of clone(neighbor)--this will always return the cloned nodes

        // Explanation:
        // each call to clone(neightbor, map) is creating a new copy of whatever node we're looking at if it has not been created
        return copy;
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