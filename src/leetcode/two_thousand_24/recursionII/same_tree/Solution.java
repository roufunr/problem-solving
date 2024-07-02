package leetcode.two_thousand_24.recursionII.same_tree;

import java.util.*;

import leetcode.two_thousand_24.bst.TreeNode;

// iterative solution
public class Solution {
    private boolean check(TreeNode m, TreeNode n) {
        if (m == null && n == null) {
            return true;
        }
        if (m == null || n == null) {
            return false;
        }
        if (m.val != n.val) {
            return false;
        }
        return true;
    }

    private boolean bothNull(TreeNode m, TreeNode n) {
        if (m == null && n == null) {
            return true;
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!check(p, q)) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty()) {
            TreeNode q1Top = queue1.poll();
            TreeNode q2Top = queue2.poll();
            if (!check(q1Top, q2Top)) {
                return false;
            }
            if (bothNull(q1Top, q2Top)) {
                continue;
            }
            queue1.offer(q1Top.left);
            queue1.offer(q1Top.right);
            queue2.offer(q2Top.left);
            queue2.offer(q2Top.right);
        }
        return true;
    }
}
