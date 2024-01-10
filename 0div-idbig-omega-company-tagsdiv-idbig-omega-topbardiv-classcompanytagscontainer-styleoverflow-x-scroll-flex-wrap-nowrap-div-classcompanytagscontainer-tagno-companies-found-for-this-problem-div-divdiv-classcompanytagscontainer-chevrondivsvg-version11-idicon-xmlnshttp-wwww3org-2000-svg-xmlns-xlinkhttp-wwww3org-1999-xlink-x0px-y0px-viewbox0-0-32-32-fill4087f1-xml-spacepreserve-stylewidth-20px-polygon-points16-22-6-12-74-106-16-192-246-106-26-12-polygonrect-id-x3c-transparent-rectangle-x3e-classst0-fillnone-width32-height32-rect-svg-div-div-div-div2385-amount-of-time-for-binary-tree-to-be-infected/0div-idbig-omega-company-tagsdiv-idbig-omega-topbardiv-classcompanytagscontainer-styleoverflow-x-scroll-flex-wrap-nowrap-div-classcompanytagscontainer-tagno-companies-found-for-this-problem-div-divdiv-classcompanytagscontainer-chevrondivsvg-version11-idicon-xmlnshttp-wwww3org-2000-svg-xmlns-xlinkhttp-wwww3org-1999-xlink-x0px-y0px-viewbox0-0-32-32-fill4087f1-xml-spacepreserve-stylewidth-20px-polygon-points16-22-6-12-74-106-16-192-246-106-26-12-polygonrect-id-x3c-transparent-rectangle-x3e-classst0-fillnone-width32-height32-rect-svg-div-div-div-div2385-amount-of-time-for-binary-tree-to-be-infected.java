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
    int res;
    public int amountOfTime(TreeNode root, int start) {
        getTime(root, start);
        return res;
    }

    public int getTime(TreeNode root, int s){
        if(root == null){
            return -1;
        }
        if(root.val == s){
            subTime(root, 0);
            return 1;
        }
        int left = getTime(root.left, s);
        int right = getTime(root.right, s);
        if(left != -1){
            subTime(root.right, left + 1);
            res = Math.max(res, left);
            return left + 1;
        }else if(right != -1){
            subTime(root.left, right + 1);
            res = Math.max(res, right);
            return right + 1;
        }else{
            return -1;
        }
    }

    public void subTime(TreeNode root, int t){
        if(root == null){
            return;
        }
        res = Math.max(res, t);
        subTime(root.left, t + 1);
        subTime(root.right, t + 1);
    }
}