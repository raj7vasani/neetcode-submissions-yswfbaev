/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<Integer> nodes = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return nodes.get(k - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        nodes.add(root.val);
        inOrder(root.right);
    }
}
