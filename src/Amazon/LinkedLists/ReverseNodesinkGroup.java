package Amazon.LinkedLists;

public class ReverseNodesinkGroup {
    // HARD, gave up
    public ListNode reverseKGroup(ListNode head, int k) {
        /*
        reversing nodes of the list k at a time
        we have list of nodes k length
        we reverse them
        we continue onto rest of list

        we can reverse through and add

        1->2->3->
        4->5->null

        can we reverse through and then add the last one based on k to new node?
        curr.next = node(3)

        how do we get 1.next to point to the next iteration of values?
        maybe go until .next == null? then start from there?
         */
        ListNode dummy = new ListNode(0);

        ListNode curr = dummy;
        ListNode newhead = head;

        while (newhead != null) {
            int counter = 3;
            if (curr.next != null) { // goes until curr is at the end
                ListNode temp = curr.next;
                curr = temp;
                counter--;
                if (counter >0) break;
            }
            ListNode prev = null; // we place prev here because we want prev=null to start over
            for (int i = 0; i < k; i++) { // reverse k nodes
                ListNode temp = newhead.next;
                newhead.next = prev;
                prev = newhead; // ends with 3 as prev
                newhead = temp; // eds with 4 as head
            }
            curr = prev; // here we connect the finished reserved iteration to what is next on curr

        }

        return dummy.next;
    }
}
