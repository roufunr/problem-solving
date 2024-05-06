package leetcode.two_thousand_24.n_ary.preorder;

import java.util.ArrayList;
import java.util.List;

import leetcode.two_thousand_24.n_ary.Node;

public class SolutionV0 {
    // recursive solution
    List<Integer> ans;

    public SolutionV0() {
        ans = new ArrayList<>();
    }

    private void walk(Node node) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        for (Node n : node.children) {
            walk(n);
        }
    }

    public List<Integer> preorder(Node root) {
        walk(root);
        return ans;
    }
}
