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
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }
        
        int n = list.size();
        ListNode res = list.get(0);

        for (int i = 1; i <= n / 2; i++) {
            res.next = list.get(n - i);
            res = res.next;

            if (i == n - i) {
                break;
            }

            res.next = list.get(i);
            res = res.next;
        }
        
        res.next = null;
    }
}
