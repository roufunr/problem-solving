package leetcode.two_thousand_24.n_ary.max_depth;

import leetcode.two_thousand_24.n_ary.Node;

public class SolutionV1 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            int max_depth = Integer.MIN_VALUE;
            for (Node n : root.children) {
                int depth = maxDepth(n);
                if (depth > max_depth) {
                    max_depth = depth;
                }
            }
            return max_depth + 1;
        }
    }
}
