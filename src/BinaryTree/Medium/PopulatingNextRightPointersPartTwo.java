package BinaryTree.Medium;

public class PopulatingNextRightPointersPartTwo {
    /*
    Since you have to walk the tree in BFS order and you're given extra references to help you do just that,
    it's intuitive, it's simple and it's fast. The first level (root) is connected already,
    so you connect the next level and then you just walk through the linked list you've just created and so on.
     */
    public void connect(NodeTree root) {
        while(root!=null) {
            NodeTree head=new NodeTree(0),end=head;
            while(root!=null) {
                if(root.left!=null) {
                    end.next=root.left;
                    end=root.left;
                }
                if(root.right!=null) {
                    end.next=root.right;
                    end=root.right;
                }
                root=root.next;
            }
            root=head.next;
    }

}

class NodeTree {
    public int val;
    public NodeTree left;
    public NodeTree right;
    public NodeTree next;

    public NodeTree() {}

    public NodeTree(int _val) {
        val = _val;
    }

    public NodeTree(int _val, NodeTree _left, NodeTree _right, NodeTree _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};