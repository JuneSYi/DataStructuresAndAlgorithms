package Amazon.LinkedLists;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int sec = 0;
        Stack<Integer> filo = new Stack<>();
        while (l1.next != null) {
            filo.push(l1.val);
            l1 = l1.next;
        }
        while (!filo.isEmpty()) {
            int c = filo.pop();
        }
        while (l2.next != null) {
            sec += l2.val;
            l2 = l2.next;
        }
        int ans = sum + sec;
        ListNode well = new ListNode();
        return well;
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}