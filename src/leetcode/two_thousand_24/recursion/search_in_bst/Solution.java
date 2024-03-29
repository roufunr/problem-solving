package leetcode.two_thousand_24.recursion.search_in_bst;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) {
            return null;
        } else if(root.val == val) {
            return root;
        } else if(root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
