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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        boolean seen = false;

        while (head != null) {
            if (nodes.contains(head)) {
                seen = true;
                break;
            }

            nodes.add(head);
            head = head.next;
        }

        return seen;
    }
}
