package leetcode.two_thousand_24.binary_tree.inorder;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3, null, null);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode one = new TreeNode(1, null, two);
        new Solution().inorderTraversal(one);
    }
}
