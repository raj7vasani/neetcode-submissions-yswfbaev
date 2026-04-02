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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeLists(lists[i], lists[i - 1]);
        }

        return lists[lists.length - 1];
    }


    // helper function to merge 2 sorted lists
    private ListNode mergeLists (ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                res.next = a;
                res = res.next;
                a = a.next;
            } else {
                res.next = b;
                res = res.next;
                b = b.next;
            }
        }

        res.next = (a != null) ? a : b;

        return dummy.next;
    }
}
