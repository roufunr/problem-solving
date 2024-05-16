package leetcode.daily_challenge.evaluate_boolean_binary_tree;

import leetcode.two_thousand_24.bst.TreeNode;

public class SolutionV1 {
    // better solution
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == 0 || root.val == 1) {
            return (1 == root.val);
        }
        boolean leftTreeResult = evaluateTree(root.left);
        boolean rightTreeResult = evaluateTree(root.right);
        if (root.val == 2) {
            return leftTreeResult || rightTreeResult;
        } else {
            return leftTreeResult && rightTreeResult;
        }
    }
}
