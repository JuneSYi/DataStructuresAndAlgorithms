package Amazon.LinkedLists;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {
    /**
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     *
     * Merge all the linked-lists into one sorted linked-list and return it.
     *
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     * Explanation: The linked-lists are:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * merging them into one sorted list:
     * 1->1->2->3->4->4->5->6
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        Queue<Integer> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list.val);
                list = list.next;
            }
        }
        while (!queue.isEmpty()) {
            pointer.next = new ListNode(queue.poll());
            pointer = pointer.next;
        }
        return dummy.next;
    }
}
