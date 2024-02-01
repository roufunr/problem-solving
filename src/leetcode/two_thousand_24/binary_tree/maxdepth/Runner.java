package leetcode.two_thousand_24.binary_tree.maxdepth;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3, nine, twenty);

        new Solution().maxDepth(three);
    }
}
