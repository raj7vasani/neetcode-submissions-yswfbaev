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
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    List<TreeNode> nodes = new ArrayList<>();

    public int maxPathSum(TreeNode root) {
        build(root, null);
        
        for (TreeNode node : nodes) {
            dfs(node, null, 0);
        }

        return max;
    }

    private void build(TreeNode curr, TreeNode par) {
        if (curr == null) return;

        nodes.add(curr);
        parent.put(curr, par);
        build(curr.left, curr);
        build(curr.right, curr);
    }

    private void dfs(TreeNode curr, TreeNode prev, int sum) {
        if (curr == null) return;

        sum += curr.val;
        max = Math.max(max, sum);

        if (curr.left != prev) {
            dfs(curr.left, curr, sum);
        }

        if (curr.right != prev) {
            dfs(curr.right, curr, sum);
        }

        if (parent.get(curr) != prev) {
            dfs(parent.get(curr), curr, sum);
        }
    }
}
