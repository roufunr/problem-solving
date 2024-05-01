package leetcode.two_thousand_24.bst.balanced_tree;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        } else if (Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return false;
        } else if (Math.abs(rightHeight - leftHeight) > 1) {
            return false;
        } else {
            return true;
        }
    }
}
