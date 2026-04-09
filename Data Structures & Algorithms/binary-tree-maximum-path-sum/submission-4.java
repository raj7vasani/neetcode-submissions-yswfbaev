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
    int res = 0;

    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode curr) {
        if (curr == null) return 0;

        int leftMax = Math.max(dfs(curr.left), 0);
        int rightMax = Math.max(dfs(curr.right), 0);
        res = Math.max(res, curr.val + leftMax + rightMax);
        return curr.val + Math.max(leftMax, rightMax);
    }
}
