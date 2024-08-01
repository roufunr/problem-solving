package leetcode.daily_challenge.may_to_july_24.evaluate_boolean_binary_tree;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == 0 || root.val == 1) {
            return (1 == root.val);
        } else if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
