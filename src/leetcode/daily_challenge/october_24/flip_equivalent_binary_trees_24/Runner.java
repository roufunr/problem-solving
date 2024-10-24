package leetcode.daily_challenge.october_24.flip_equivalent_binary_trees_24;

import leetcode.two_thousand_24.bst.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        TreeNode right1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(0);
        TreeNode right2 = new TreeNode(1);

        root1.left = null;
        root1.right = right1;

        root2.left = null;
        root2.right = right2;
        System.out.println(new Solution().flipEquiv(root1, root2));
    }
}
