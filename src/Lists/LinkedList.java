package Lists;

public class LinkedList {
    public static void main(String[] args) {
        Node head = new Node(6);
        Node testB = new Node(4);
        Node testC = new Node(3);
        Node testD = new Node(2);
        Node testE = new Node(0);

        head.next = testB;
        testB.next = testC;
        testC.next = testD;
        testD.next = testE;
        LinkedList run = new LinkedList();
        System.out.println(run.countNodes(head));
    }

    public int countNodes(Node inputHead) {
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
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class ListNode {

}
