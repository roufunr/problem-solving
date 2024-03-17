package leetcode.two_thousand_24.binary_tree.pathsum;
import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    private boolean found;

    private void pathsum(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum += node.val;
            if (sum == targetSum) {
                found = true;
                return;
            }
        }
        pathsum(node.left, sum + node.val, targetSum);
        pathsum(node.right, sum + node.val, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        found = false;
        pathsum(root, 0, targetSum);
        return found;
    }
}
