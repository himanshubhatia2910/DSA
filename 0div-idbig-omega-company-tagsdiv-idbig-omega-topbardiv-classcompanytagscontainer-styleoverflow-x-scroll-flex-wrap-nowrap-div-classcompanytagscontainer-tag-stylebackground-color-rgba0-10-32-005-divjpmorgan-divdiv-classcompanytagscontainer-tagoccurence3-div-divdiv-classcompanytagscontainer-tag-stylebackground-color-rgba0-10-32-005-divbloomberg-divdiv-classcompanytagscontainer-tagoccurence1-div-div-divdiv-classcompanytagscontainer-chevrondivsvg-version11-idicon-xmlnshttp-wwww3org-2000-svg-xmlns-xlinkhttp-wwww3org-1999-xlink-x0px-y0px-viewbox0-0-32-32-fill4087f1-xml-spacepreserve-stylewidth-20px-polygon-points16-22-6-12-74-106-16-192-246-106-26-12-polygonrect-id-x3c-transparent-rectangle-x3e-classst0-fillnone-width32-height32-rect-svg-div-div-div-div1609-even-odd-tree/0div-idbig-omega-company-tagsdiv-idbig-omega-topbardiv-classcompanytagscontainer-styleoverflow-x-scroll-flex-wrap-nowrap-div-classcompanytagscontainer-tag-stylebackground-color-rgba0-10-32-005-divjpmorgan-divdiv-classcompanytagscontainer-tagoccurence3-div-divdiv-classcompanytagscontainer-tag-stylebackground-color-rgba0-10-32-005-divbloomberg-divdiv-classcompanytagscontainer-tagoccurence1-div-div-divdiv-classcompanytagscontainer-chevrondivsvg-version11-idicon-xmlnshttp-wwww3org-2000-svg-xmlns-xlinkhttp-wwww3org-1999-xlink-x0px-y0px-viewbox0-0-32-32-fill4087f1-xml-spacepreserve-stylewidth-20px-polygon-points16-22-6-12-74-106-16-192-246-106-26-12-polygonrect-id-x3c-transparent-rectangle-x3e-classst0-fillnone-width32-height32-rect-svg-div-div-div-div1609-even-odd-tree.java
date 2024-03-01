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
   public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean isEven = true;
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            int prev = nodes.peek().val; 
  
            for (int i = 0; i < levelSize; i++) {
                var current = nodes.poll();        
                if (isEven == (prev % 2 == 0)) {
                    return false;
                }
                if (current.left != null) {
                    nodes.add(current.left);
                }
                if (current.right != null) {
                    nodes.add(current.right);
                } 
                if (i == 0) continue;

                if (isEven == (current.val % 2 == 0)) {
                    return false;
                }
                if (isEven && prev >= current.val || !isEven && prev <= current.val) {
                    return false;
                }
                prev = current.val;       
                                       
            }
            isEven = !isEven;
        }

        return true;
    }
}