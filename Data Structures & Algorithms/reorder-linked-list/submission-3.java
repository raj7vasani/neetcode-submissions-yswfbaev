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

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode l1 = head;
        ListNode list2 = slow;
        ListNode mid = slow;
        
        ListNode l2 = reverseList(list2);

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        while (l1 != mid) {
            res.next = l1;
            l1 = l1.next;

            res.next.next = l2;
            l2 = l2.next;

            res = res.next.next;
        }
        res.next = l2;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
