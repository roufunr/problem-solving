package leetcode.two_thousand_24.n_ary.postorder;

import java.util.ArrayList;
import java.util.List;

import leetcode.two_thousand_24.n_ary.Node;

public class Solution {
    private List<Integer> ans;
    public Solution() {
        ans = new ArrayList<>();
    }
    private void walk(Node node) {
        if(node == null) {
            return;
        }
        for(Node n : node.children) {
            walk(n);
        }
        ans.add(node.val);
    }
    public List<Integer> postorder(Node root) {
        walk(root);
        return ans;
    }
}