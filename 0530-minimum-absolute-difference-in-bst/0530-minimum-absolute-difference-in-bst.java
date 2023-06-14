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
   int last = -1000000, min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }

    private void traverse(TreeNode root){    
        if (root.left != null) traverse(root.left);

        min = Math.min(min, root.val - last);
        last = root.val;

        if (root.right != null) traverse(root.right);
    }
}