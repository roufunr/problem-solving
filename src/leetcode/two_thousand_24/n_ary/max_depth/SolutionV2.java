package leetcode.two_thousand_24.n_ary.max_depth;

import java.util.Stack;

import leetcode.two_thousand_24.n_ary.Node;

class Pair {
    public Node node;
    public int depth;

    public Pair(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class SolutionV2 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Stack<Pair> stack = new Stack<>();
        int maximumDepth = -1;
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            if (top.node.children.isEmpty()) {
                maximumDepth = maximumDepth < top.depth ? top.depth : maximumDepth;
            }
            for (int i = top.node.children.size() - 1; i >= 0; i--) {
                stack.push(new Pair(top.node.children.get(i), top.depth + 1));
            }
        }
        return maximumDepth;
    }
}
