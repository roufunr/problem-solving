package leetcode.two_thousand_24.recursionII.same_tree;

import leetcode.two_thousand_24.bst.TreeNode;

public class SolutonII {
    // recrusive solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
