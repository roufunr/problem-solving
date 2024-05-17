package leetcode.daily_challenge.remove_leaves_with_a_given_value;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                return null;
            } else {
                return root;
            }
        }
        return root;
    }
}
