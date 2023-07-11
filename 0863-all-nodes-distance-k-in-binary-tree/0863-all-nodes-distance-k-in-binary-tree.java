/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean isFound;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (k == 0) {
            res.add(target.val);
            return res;
        }
        isFound = false;
        Stack<TreeNode> parents = new Stack<>();
        dfsToFind(root, target, parents);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(target.val);
        int count = 1;
        if (!parents.isEmpty()) queue.add(parents.pop());
        if (target.left != null) queue.add(target.left);
        if (target.right != null) queue.add(target.right);

        while (!queue.isEmpty()) {
            if (count++ == k) break;
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                set.add(node.val);
                if (node.left != null && !set.contains(node.left.val)) {
                    tempQueue.offer(node.left);
                }
                if (node.right != null && !set.contains(node.right.val)) {
                    tempQueue.offer(node.right);
                }
            }
            if (!parents.isEmpty()) tempQueue.add(parents.pop());
            queue = tempQueue;
        }
        while (!queue.isEmpty()) res.add(queue.poll().val);
        return res;
    }

    private void dfsToFind(TreeNode node, TreeNode target, Stack<TreeNode> stack) {
        if (node == null) return;
        if (node == target) {
            isFound = true;
            return;
        }
        if (!isFound) stack.add(node);
        if (!isFound) dfsToFind(node.left, target, stack);
        if (!isFound) dfsToFind(node.right, target, stack);
        if (!isFound && !stack.isEmpty()) stack.pop();
    }
}