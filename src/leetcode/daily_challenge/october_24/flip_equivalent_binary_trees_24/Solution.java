package leetcode.daily_challenge.october_24.flip_equivalent_binary_trees_24;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        } else if(root1 == null || root2 == null) {
            return false;
        } else if(root1.val != root2.val) {
            return false;
        }

        boolean swap = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        boolean noSwap = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        return swap || noSwap;
    }
}
