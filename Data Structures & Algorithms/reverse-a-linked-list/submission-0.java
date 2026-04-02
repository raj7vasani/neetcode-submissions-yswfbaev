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
    public ListNode reverseList(ListNode head) {
        List<Integer> res = new ArrayList<>();

        while (head != null) {
            res.add(head.val);
            head = head.next;
        } 
        
        ListNode start = new ListNode(0);
        ListNode curr = start;

        for (int i = res.size() - 1; i >= 0; i--) {
            curr.next = new ListNode(res.get(i));
            curr = curr.next;
        }
        
        return start.next;
    }
}
