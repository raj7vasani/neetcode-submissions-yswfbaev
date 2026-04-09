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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int getMax(TreeNode node) {
        if (node == null) return 0;

        int left = getMax(node.left);
        int right = getMax(node.right);

        int path = node.val + Math.max(left, right);
        return Math.max(0, path);
    }

    public void dfs(TreeNode curr) {
        if (curr == null) return;

        int left = getMax(curr.left);
        int right = getMax(curr.right);
        max = Math.max(max, curr.val + left + right);
        dfs(curr.left);
        dfs(curr.right);
    }
}
