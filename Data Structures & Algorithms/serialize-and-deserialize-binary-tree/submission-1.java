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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                res.append("N,");
                continue;
            }

            res.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty() || data == null) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {
            TreeNode parent = q.poll();

            if (!nodes[i].equals("N")) {
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(parent.left);
            }
            i++;

            if (!nodes[i].equals("N") && i < nodes.length) {
                parent.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(parent.right);
            }
            i++;
        }

        return root;
    }
}
