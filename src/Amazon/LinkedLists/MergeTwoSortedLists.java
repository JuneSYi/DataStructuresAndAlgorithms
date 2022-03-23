package Amazon.LinkedLists;

public class MergeTwoSortedLists {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null && list1.val >= list2.val) {
                ListNode node = new ListNode(list2.val);
                curr.next = node;
                curr = curr.next;
                list2 = list2.next;
            } else if (list1 != null && list2 != null && list1.val < list2.val){
                ListNode node = new ListNode(list1.val);
                curr.next = node;
                curr = curr.next;
                list1 = list1.next;
            } else if (list1 == null && list2 != null) {
                ListNode node = new ListNode(list2.val);
                curr.next = node;
                curr = curr.next;
                list2 = list2.next;
            } else {
                ListNode node = new ListNode(list1.val);
                curr.next = node;
                curr = curr.next;
                list1 = list1.next;
            }
        }

        return dummy.next;
    }

    public ListNode optimized(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1); // dummy node

        ListNode prev = prehead; // pointer
        while (l1 != null && l2 != null) { // while one or either are not null
            if (l1.val <= l2.val) { // if l1.val is less or equal, we'll add this for sorting order
                prev.next = l1; // we add l1 to first value
                l1 = l1.next; // move to next node
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next; // prev now will equal next node
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1; // prev.next will = if (l1 == null) { l2;} else{ l1;}

        return prehead.next; // return the first starting node of what we just created.
    }

    public ListNode recursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
