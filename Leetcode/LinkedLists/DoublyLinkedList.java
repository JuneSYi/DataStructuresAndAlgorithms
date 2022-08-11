package LinkedLists;

public class DoublyLinkedList {
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

        testB.prev = head;
        testC.prev = testB;
        testD.prev = testC;
        testE.prev = testD;
    }
}

class NodeTwo {
    int data;
    NodeTwo next;
    NodeTwo prev;

    public NodeTwo(int data) {
        this.data = data;
    }
}
