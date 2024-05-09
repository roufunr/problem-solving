package leetcode.two_thousand_24.n_ary.max_depth;

import leetcode.two_thousand_24.n_ary.Node;

public class Solution {
    public int max_dep = 0;
    private void walk(Node node, int so_far_depth) {
        if(node == null) {
            return;
        }
        max_dep = max_dep < (so_far_depth + 1) ? so_far_depth + 1 : max_dep;
        for(Node n : node.children) {
            walk(n, so_far_depth + 1);
        }
    }
    public int maxDepth(Node root) {
        walk(root, 0);
        return max_dep;
    }
}