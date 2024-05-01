package leetcode.two_thousand_24.bst.lca;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        int m = p.val > q.val ? q.val : p.val;
        int n = p.val < q.val ? q.val : p.val;
        // m <= n
        if (root.val >= m && root.val <= n) {
            return root;
        } else if (root.val < m && root.val < n) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}