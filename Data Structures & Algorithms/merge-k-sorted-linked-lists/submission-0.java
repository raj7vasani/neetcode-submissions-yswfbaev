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
        List<Integer> res = new ArrayList<>();

        for (ListNode list : lists) {
            while (list != null) {
                res.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(res);

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        for (int n : res) {
            result.next = new ListNode(n);
            result = result.next;
        }

        return dummy.next;
    }
}
