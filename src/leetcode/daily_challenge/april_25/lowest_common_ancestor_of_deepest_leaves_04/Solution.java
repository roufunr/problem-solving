package leetcode.daily_challenge.april_25.lowest_common_ancestor_of_deepest_leaves_04;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (left.getValue() > right.getValue()) {
            return new Pair(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return new Pair(right.getKey(), right.getValue() + 1);
        }
        return new Pair(root, left.getValue() + 1);
    }
}