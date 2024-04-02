package leetcode.two_thousand_24.recursion.maximum_depth_of_a_binary_tree;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    private int maxDepth = 0;
    private void calculate(TreeNode node, int depth) {
        if(node == null) {
            return;
        }
        depth = depth + 1;
        maxDepth = depth > maxDepth ? depth : maxDepth;
        calculate(node.left, depth);
        calculate(node.right, depth);
    }
    public int maxDepth(TreeNode root) {
        calculate(root, 0);
        return maxDepth;
    }
}
