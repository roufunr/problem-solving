package leetcode.two_thousand_24.bst.balanced_tree;

import leetcode.two_thousand_24.bst.TreeNode;

// better solution in terms of clean code
class Pair {
    public int height;
    public boolean isBalanced;

    public Pair(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

public class Solution {
    public Pair getHeight(TreeNode node) {
        if (node == null) {
            return new Pair(0, true);
        }
        Pair leftPair = getHeight(node.left);
        Pair rightPair = getHeight(node.right);
        if (leftPair.isBalanced && rightPair.isBalanced && Math.abs(leftPair.height - rightPair.height) <= 1) {
            return new Pair(Math.max(leftPair.height, rightPair.height) + 1, true);
        } else {
            return new Pair(Math.max(leftPair.height, rightPair.height) + 1, false);
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root).isBalanced;
    }
}
