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
     public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            return 1;
        }
        Queue<TreeNode> q=new LinkedList<>();
        root.val=1;
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.left==null && temp.right==null) {
                return temp.val;
            }
            if(temp.left!=null) {
                temp.left.val=temp.val+1;
                q.add(temp.left);
            }
            if(temp.right!=null) {
                temp.right.val=temp.val+1;
                q.add(temp.right);
            }
        }
        return 0;
    }
}