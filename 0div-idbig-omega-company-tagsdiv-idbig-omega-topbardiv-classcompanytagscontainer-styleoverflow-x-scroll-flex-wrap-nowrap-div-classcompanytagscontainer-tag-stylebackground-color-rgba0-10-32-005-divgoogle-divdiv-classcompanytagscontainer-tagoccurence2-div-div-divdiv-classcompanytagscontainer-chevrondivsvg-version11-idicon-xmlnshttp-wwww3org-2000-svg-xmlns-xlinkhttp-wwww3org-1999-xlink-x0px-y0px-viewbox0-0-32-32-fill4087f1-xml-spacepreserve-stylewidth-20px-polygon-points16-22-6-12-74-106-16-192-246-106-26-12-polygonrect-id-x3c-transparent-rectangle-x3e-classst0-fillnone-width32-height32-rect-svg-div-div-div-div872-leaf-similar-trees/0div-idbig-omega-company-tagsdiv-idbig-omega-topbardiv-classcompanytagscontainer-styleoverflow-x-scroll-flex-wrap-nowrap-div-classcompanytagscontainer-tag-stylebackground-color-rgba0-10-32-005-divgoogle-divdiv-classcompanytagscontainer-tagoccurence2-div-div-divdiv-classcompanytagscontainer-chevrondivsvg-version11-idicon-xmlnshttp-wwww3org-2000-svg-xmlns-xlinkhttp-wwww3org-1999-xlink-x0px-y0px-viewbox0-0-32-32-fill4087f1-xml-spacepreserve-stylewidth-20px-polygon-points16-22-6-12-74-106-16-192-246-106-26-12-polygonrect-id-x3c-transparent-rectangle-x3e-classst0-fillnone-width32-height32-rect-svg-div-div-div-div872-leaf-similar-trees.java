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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        helper(l1,root1);
        helper(l2,root2);
        
        if(l1.equals(l2)) return true;
        else return false;
    }
     void helper(List<Integer> list, TreeNode root)
    {
        if(root==null) return;
        
        if(root.left==null && root.right==null)
        {
            list.add(root.val);
            return;
        }
        else{
            helper(list,root.left);
            helper(list,root.right);
        }
    }
}