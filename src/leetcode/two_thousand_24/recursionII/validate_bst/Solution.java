package leetcode.two_thousand_24.recursionII.validate_bst;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private long findRightMin(TreeNode node) {
        if (node == null) {
            return Long.MAX_VALUE;
        }
        return Math.min(node.val, findRightMin(node.right));
    }

    private long findLefttMax(TreeNode node) {
        if (node == null) {
            return Long.MIN_VALUE;
        }
        return Math.max(node.val, findLefttMax(node.left));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        long leftMax = findLefttMax(root.left);
        long rightMin = findRightMin(root.right);
        if(root.val <= leftMax || root.val >= rightMin) {
            return false;
        } 
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
