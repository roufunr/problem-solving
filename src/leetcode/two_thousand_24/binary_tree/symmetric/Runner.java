package leetcode.two_thousand_24.binary_tree.symmetric;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2, three, four);
        TreeNode three_ = new TreeNode(3);
        TreeNode four_ = new TreeNode(4);
        TreeNode two_ = new TreeNode(2, four_, three_);
        TreeNode one = new TreeNode(1, two, two_);

        new Solution().isSymmetric(one);

    }
}
