package Lists;

public class DoublyLinkedList {
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

        testB.prev = head;
        testC.prev = testB;
        testD.prev = testC;
        testE.prev = testD;
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }
}
