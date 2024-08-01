package leetcode.daily_challenge.may_to_july_24.bst_to_gst;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private int nodeSum;

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        nodeSum += root.val;
        root.val = nodeSum;
        helper(root.left);

    }

    public TreeNode bstToGst(TreeNode root) {
        nodeSum = 0;
        helper(root);
        return root;
    }
}
