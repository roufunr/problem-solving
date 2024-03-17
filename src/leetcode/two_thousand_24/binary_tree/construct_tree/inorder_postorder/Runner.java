package leetcode.two_thousand_24.binary_tree.construct_tree.inorder_postorder;

import leetcode.two_thousand_24.binary_tree.tree.*;
public class Runner {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode tree = new Solution().buildTree(inorder, postorder);
        System.out.println(tree);
    }
}
