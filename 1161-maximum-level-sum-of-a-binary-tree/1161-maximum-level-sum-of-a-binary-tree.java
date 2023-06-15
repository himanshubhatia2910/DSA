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
    public int maxLevelSum(TreeNode root) {
        int maxSum = root.val;
       int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int counter = 0;
        while (!queue.isEmpty()){
            counter++;
            int queueSize = queue.size();
            int levelSum = 0;
            for (int i = 0; i < queueSize; i++){
                TreeNode node = queue.poll();
                levelSum += node.val;

                if(node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if(levelSum > maxSum){
                maxSum = levelSum;
                level = counter;
            }
        }

        return level;
    }
}