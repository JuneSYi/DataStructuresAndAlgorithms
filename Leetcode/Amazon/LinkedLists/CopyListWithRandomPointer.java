package Amazon.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    /**
     * An intuitive solution is to keep a hash table for each node in the list, via which we just need to
     * iterate the list in 2 rounds respectively to create nodes and assign the values for their random pointers.
     * As a result, the space complexity of this solution is O(N), although with a linear time complexity.
     *
     * Note: if we do not consider the space reversed for the output, then we could say that the algorithm does not
     * consume any additional memory during the processing, i.e. O(1) space complexity
     *
     * As an optimised solution, we could reduce the space complexity into constant. The idea is to associate the
     * original node with its copy node in a single linked list. In this way, we don't need extra space to keep
     * track of the new nodes.
     *
     * The algorithm is composed of the follow three steps which are also 3 iteration rounds.
     *
     * 1. Iterate the original list and duplicate each node. The duplicate
     * of each node follows its original immediately.
     * 2. Iterate the new list and assign the random pointer for each
     * duplicated node.
     * 3. Restore the original list and extract the duplicated nodes.
     */
    public Node copyRandomList(Node head) {
        /*
        construct a deep copy
         */
        Node dummy = new Node(0);
        dummy.next = new Node(head.val);
        Node ans = dummy.next;
        while (head != null) {
            if (head.next != null) ans.next = new Node(head.next.val);
            if (head.random != null) ans.random = new Node(head.random.val);
            ans = ans.next;
            head = head.next;
        }

        return dummy.next;
    }

    /** if we do only 1 pass, the random pointer could point to a node not created since it's random
     * so we do 2 passes
     * 1st pass - take each input node and create a deep copy of the nodes
     * also create a hashmap where we map the old node to the new copy
     * 2nd pass, where we doo all the pointer connecting
     */
    public Node optimize(Node head) {
        if(head == null) return null;

        // original node, new node
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0); // dummy node
        Node curdummy = dummy; // pointer to dummy node

        // deep copy the list node without random pointer
        Node curhead = head; // pointer to original node
        while(curhead != null){ // loops through all of original node
            curdummy.next = new Node(curhead.val); // creating dummynode deep copy using head pointer
            map.put(curhead, curdummy.next); // we map current node as key, values represent same node for dummy (.next because dummy starts one step behind)
            curdummy = curdummy.next; // we now move the pointer up one to current
            curhead = curhead.next; // we move the pointer for head up one
        }

        // once intial node list is made, now we can do it again but with random pointer
        // deep copy the random pointer
        curhead = head; // start curhead over at head node
        curdummy = dummy.next; // dummy node list is already made, we can start curdummy on first node
        while(curdummy != null){ // loops through all the created node
            curdummy.random = map.get(curhead.random); //we attach the value of .random for new node to whichever node is associated with original.random
            curdummy = curdummy.next; // move pointer up 1
            curhead = curhead.next; // move pointer up 1
        }

        return dummy.next;
    }

    // https://www.youtube.com/watch?v=Jo4Oko5Y6Tg&ab_channel=NareshGupta
    // explanation starting at 7:00
    // 3 loops, 1st is making A-A`-B-B`-C-C`-etc
    // 2nd is adding random pointers
    // 3rd is ??
    public Node noHashMap(Node head) {
        Node current = head; // current is a pointer

        while (current != null) { // clone initial node
            Node copy = new Node(current.val); //new copy node with current.val
            copy.next = current.next; // match .next with current.next
            //so we created copy and copy.next,
            current.next = copy; // then have current.next become copy.
            // This is how we'll make A-A`-B-B`-C-C`-etc as shown in the yt
            current = current.next.next; //dont understand how this is possible.
        }

        current = head;
        while(current != null) {
            if (current.random == null) {
                current.next.random = null;
            } else {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        Node dummyHead = new Node(-1);
        Node dummy = dummyHead;
        current = head;

        while(current != null) {
            dummy.next = current.next;
            dummy = dummy.next;
            current.next = current.next.next;
            current = current.next;
        }

        return dummyHead.next;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}