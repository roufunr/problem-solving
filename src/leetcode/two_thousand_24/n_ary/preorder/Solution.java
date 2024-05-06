package leetcode.two_thousand_24.n_ary.preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.two_thousand_24.n_ary.Node;

public class Solution {
    // iterative solution
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            ans.add(top.val);
            for (int i = top.children.size() - 1; i >= 0; i--) {
                stack.push(top.children.get(i));
            }
        }
        return ans;
    }
}