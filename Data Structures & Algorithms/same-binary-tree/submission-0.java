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
    public boolean isSameTree(TreeNode p, TreeNode q) {  
        if (p == null && q == null) return true;
        Queue<TreeNode> nodeP = new LinkedList<>();
        Queue<TreeNode> nodeQ = new LinkedList<>();

        if (p == null && q != null) return false;
        if (q == null && p != null) return false;
        
        nodeP.add(p);
        nodeQ.add(q);

        while (!nodeP.isEmpty() && !nodeQ.isEmpty()) {
            int pSize = nodeP.size();
            int qSize = nodeQ.size();

            if (pSize != qSize) return false;
            
            for (int i = 0; i < pSize; i++) {
                TreeNode pnode = nodeP.poll();
                TreeNode qnode = nodeQ.poll();

                if (pnode.val != qnode.val) return false;

                if ((pnode.left == null) != (qnode.left == null)) return false;
                if ((pnode.right == null) != (qnode.right == null)) return false;

                if (pnode.left != null) {
                    nodeP.add(pnode.left);
                    nodeQ.add(qnode.left);
                }

                if (pnode.right != null) {
                    nodeP.add(pnode.right);
                    nodeQ.add(qnode.right);
                }
            }
        }

        return nodeP.isEmpty() && nodeQ.isEmpty();
    }
}
