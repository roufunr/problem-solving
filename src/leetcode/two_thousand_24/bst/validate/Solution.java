package leetcode.two_thousand_24.bst.validate;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
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
            return Integer.MIN_VALUE;
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
        if (root.left != null) {
            long leftMax = findMax(root.left);
            if (leftMax >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            long rightMin = findMin(root.right);
            if (rightMin <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}