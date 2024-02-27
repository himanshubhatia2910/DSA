class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        // Check if the root is null
        if (root == null)
            return 0;

        
        int[] diameter = {0};
        calculateDiameter(root, diameter);

   
        return diameter[0] - 1;
    }

   
    private int calculateDiameter(TreeNode node, int[] diameter) {
       
        if (node == null)
            return 0;

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = calculateDiameter(node.left, diameter);
        int rightHeight = calculateDiameter(node.right, diameter);

        // Calculate the diameter passing through the current node
        int diameterThroughNode = leftHeight + rightHeight + 1;

        // Update the overall diameter if the current node contributes to a larger diameter
        diameter[0] = Math.max(diameter[0], diameterThroughNode);

        // Return the maximum height of the left and right subtrees
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
