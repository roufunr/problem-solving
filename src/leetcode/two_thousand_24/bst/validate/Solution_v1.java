package leetcode.two_thousand_24.bst.validate;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution_v1 {
    private long findMin(TreeNode node) {
        if (node == null) {
            return Long.MAX_VALUE;
        }
        long leftMin = findMin(node.left);
        long rightMin = findMin(node.right);
        return leftMin < node.val ? (leftMin < rightMin ? leftMin : rightMin)
                : (node.val < rightMin ? node.val : rightMin);
    }

    private long findMax(TreeNode node) {
        if (node == null) {
            return Long.MIN_VALUE;
        }
        long leftMax = findMax(node.left);
        long rightMax = findMax(node.right);
        return leftMax > node.val ? (leftMax > rightMax ? leftMax : rightMax)
                : (node.val > rightMax ? node.val : rightMax);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        long leftMax = findMax(root.left);
        long rightMin = findMin(root.right);

        if (leftMax >= root.val || rightMin <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
