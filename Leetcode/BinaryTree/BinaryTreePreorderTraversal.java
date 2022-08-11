package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.
 *     - starts with root, enters every node it meets along the way down immediately.
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode anon = new TreeNode(3);
        TreeNode qnon = new TreeNode(2, anon, null);
        TreeNode root = new TreeNode(1, null, qnon);
        BinaryTreePreorderTraversal runtime = new BinaryTreePreorderTraversal();
        runtime.preorderTraversalUsingStack(root);
        System.out.println(runtime.answer);
    }
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return ans;
        dfs(root);
        return ans;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);

    }
    /**
    Taking pre-order traversal as an example, in each iteration, we pop one node from the stack and visit this node.
    Then if this node has a right child, push its right child into the stack. If this node has a left child,
    push its left child into the stack. It is noteworthy that we push the right child first so that we can visit the
    left child first since the nature of the stack is LIFO(last in first out). After that, we can continue to the next
    iteration until the stack is empty.
     */
    List<Integer> answer = new ArrayList<>();

    public List<Integer> preorderTraversalUsingStack(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        if (root != null) {
            s.push(root); // if not an empty value, we add item to stack
        }
        TreeNode cur; // declare Treenode with name cur
        while (!s.empty()) { // .empty() returns true if stack is empty, else false
            // because it is !s.empty(), the statement will remain true until stack is emptied.
            cur = s.pop(); // pop removes an item from the stack. we assign pop() to variable cur
            answer.add(cur.val);            // visit the root? this pops the top node (root) and adds it to answer
            if (cur.right != null) { //if value exists, we continue below
                s.push(cur.right);          // push right child to stack if it is not null
            }
            if (cur.left != null) {
                s.push(cur.left);           // push left child to stack if it is not null
            }
        }
        return answer;
    }
}
/* 2 different solutions
public List<Integer> preorderTraversal(TreeNode node) {
	List<Integer> list = new LinkedList<Integer>();
	Stack<TreeNode> rights = new Stack<TreeNode>();
	while(node != null) {
		list.add(node.val);
		if (node.right != null) {
			rights.push(node.right);
		}
		node = node.left;
		if (node == null && !rights.isEmpty()) {
			node = rights.pop();
		}
	}
    return list;
}

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if (node != null) {
            result.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
    }
    return result;
}
 */