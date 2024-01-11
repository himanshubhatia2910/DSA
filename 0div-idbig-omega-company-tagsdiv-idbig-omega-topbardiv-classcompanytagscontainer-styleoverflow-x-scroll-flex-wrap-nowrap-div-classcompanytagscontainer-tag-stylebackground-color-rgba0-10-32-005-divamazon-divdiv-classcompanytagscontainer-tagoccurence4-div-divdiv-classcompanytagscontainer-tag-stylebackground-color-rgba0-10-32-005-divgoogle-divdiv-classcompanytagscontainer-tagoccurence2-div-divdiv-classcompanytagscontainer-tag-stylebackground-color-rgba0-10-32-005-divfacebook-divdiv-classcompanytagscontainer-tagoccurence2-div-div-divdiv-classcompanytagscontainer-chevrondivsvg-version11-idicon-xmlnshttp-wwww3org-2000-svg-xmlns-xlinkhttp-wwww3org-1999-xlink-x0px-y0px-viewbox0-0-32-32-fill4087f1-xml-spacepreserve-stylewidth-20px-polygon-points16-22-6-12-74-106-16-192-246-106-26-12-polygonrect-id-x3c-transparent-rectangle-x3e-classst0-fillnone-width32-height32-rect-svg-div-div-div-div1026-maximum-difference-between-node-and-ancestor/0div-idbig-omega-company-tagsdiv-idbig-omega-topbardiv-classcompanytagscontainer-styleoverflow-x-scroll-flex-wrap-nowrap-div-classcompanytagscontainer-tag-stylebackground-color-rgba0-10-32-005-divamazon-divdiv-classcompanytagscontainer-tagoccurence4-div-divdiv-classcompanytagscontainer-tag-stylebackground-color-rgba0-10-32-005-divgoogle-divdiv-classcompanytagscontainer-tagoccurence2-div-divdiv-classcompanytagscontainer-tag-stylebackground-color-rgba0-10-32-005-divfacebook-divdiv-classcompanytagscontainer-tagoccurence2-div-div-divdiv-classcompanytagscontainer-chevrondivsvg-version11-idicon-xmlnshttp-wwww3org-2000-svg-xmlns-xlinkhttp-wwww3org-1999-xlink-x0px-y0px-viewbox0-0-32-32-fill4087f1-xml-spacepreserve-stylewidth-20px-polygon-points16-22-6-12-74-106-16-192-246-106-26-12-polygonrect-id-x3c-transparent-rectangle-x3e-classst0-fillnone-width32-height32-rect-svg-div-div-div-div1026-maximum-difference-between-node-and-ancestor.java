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
     int v = 0;
    public int maxAncestorDiff(TreeNode root) {
        fun(root, root.val, root.val);
        int p = v;
        v = 0;
        return p;
    }
    public void fun(TreeNode root, int ma, int mi){
        if(root == null){
            return;
        }
        int mi1 = Math.min(root.val, mi);
        int ma1 = Math.max(root.val, ma);
        fun(root.left, ma1, mi1);
        fun(root.right, ma1, mi1);
        int p = Math.max(Math.abs(root.val - mi), Math.abs(root.val - ma));
        v = Math.max(v, p);
        return;
    }
}