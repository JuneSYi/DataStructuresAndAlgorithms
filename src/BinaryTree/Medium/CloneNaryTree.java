package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneNaryTree {
    /** Leetcode 1490
     problem is similar to 133. Clone Graph
     * Given a root of an N-ary tree, return a deep copy (clone) of the tree.
     *
     * Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.
     *
     * class Node {
     *     public int val;
     *     public List<Node> children;
     * }
     * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
     *
     */
    public Node cloneTree(Node root) {
        Map<Node, Node> map = new HashMap<>();
        return clone(root, map);
    }

    private Node clone(Node root, Map<Node, Node> map) {
        //base case
        if (root == null) return null;
        if(map.containsKey(root)) return map.get(root);

        map.put(root, new Node(root.val)); // we only need to put the value into the node, children will be a new arraylist

        // recursive step
        for (Node next : root.children) {
            map.get(root).children.add(clone(next,map));
        }
        return map.get(root);
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
