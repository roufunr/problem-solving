package leetcode.two_thousand_24.binary_tree.maxdepth;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    private int answer;

    private void depth(TreeNode node, int d) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            answer = Math.max(answer, d);
        }
        depth(node.left, d + 1);
        depth(node.right, d + 1);
    }

    public int maxDepth(TreeNode root) {
        answer = 0;
        depth(root, 1);
        return answer;
    }
}