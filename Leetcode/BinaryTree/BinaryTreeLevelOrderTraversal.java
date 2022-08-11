package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // how we organize the data
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>(); // what we'll return

        if(root == null) return wrapList;

        queue.add(root); //add input into queue
        while(!queue.isEmpty()){ //while empty, keep executing
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) { // we do a for loop so we can go through entire queue at current size
                if(queue.peek().left != null) queue.add(queue.peek().left); //we add the left node to the queue
                if(queue.peek().right != null) queue.add(queue.peek().right); // add right node
                subList.add(queue.poll().val); // we add the value at the level it's at, starting with root node
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
