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
    public int maxDepth(TreeNode root) {
        // DFS Stack Solution
        Stack<Pair<TreeNode, Integer>> s = new Stack<>();
        if (root != null) s.push(new Pair<>(root, 1));

        int res = 0;
        while (!s.isEmpty()) {
            Pair<TreeNode, Integer> curr = s.pop();
            TreeNode node = curr.getKey();
            int depth = curr.getValue();

            res = Math.max(res, depth);

            if (node.left != null) {
                s.push(new Pair<>(node.left, depth + 1));
            }

            if (node.right != null) {
                s.push(new Pair<>(node.right, depth + 1));
            }
        }

        return res;
    }
}
