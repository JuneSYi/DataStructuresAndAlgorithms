package Lists;

public class LinkedList {
    public static void main(String[] args) {
        NodeTwo head = new NodeTwo(6);
        NodeTwo testB = new NodeTwo(4);
        NodeTwo testC = new NodeTwo(3);
        NodeTwo testD = new NodeTwo(2);
        NodeTwo testE = new NodeTwo(0);

        head.next = testB;
        testB.next = testC;
        testC.next = testD;
        testD.next = testE;
        LinkedList run = new LinkedList();
        System.out.println(run.countNodes(head));
    }

    public int countNodes(NodeTwo inputHead) {
        int count = 1;
        while (inputHead.next != null) {
            count++;
            inputHead = inputHead.next;
        }
        return count;
    }
}

class Node {
    int data;
    NodeTwo next;

    public Node(int data) {
        this.data = data;
    }
}
