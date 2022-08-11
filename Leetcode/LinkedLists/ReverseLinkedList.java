package LinkedLists;

public class ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    //Using Recursion
    public ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null ) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        newHead = next;
        head = next;
        return reverseList(head, newHead);
    }

    public ListNode reverseListTwo(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListTwo(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    /**
     * we're only given the head node (ListNode head)
     * e.g. [1,2,3,4,x]
     */
    public ListNode reverse(ListNode head) { // iterative solution
        ListNode prev = null; // initializing the previous node
        ListNode curr = head; // starting point
        while (curr != null) {
            ListNode next = curr.next; //creates a temporary node, value is 2 in e.g.
            curr.next = prev; // link to curr.next(2) no longer exist, link goes to previous node which in this case is null
            prev = curr; // prev node becomes 1
            curr = next; // current node becomes 2
        /*
        Iteration 2, curr = 2, prev = 1
        ListNode next = curr.next; // next = 3
        curr.next = prev; // link to curr.next(3) is changed to 1
        prev = curr; //  prev node becomes 2
        curr = next; //  current node becomes 3
        */
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        ListNode testB = new ListNode(4);
        ListNode testC = new ListNode(3);
        ListNode testD = new ListNode(2);
        ListNode testE = new ListNode(0);

        head.next = testB;
        testB.next = testC;
        testC.next = testD;
        testD.next = testE;

        ReverseLinkedList run = new ReverseLinkedList();

        System.out.println(head.next);
        System.out.println(testB.next);
        System.out.println(testC.next);
        System.out.println(testD.next);

        run.reverse(head);

        System.out.println(head.next);
        System.out.println(testB.next);
        System.out.println(testC.next);
        System.out.println(testD.next);
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
