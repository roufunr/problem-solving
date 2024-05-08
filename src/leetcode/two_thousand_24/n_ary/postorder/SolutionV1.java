package leetcode.two_thousand_24.n_ary.postorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.two_thousand_24.n_ary.Node;

public class SolutionV1 {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node stack1Top = stack1.pop();
            for (int i = 0; i < stack1Top.children.size(); i++) {
                stack1.push(stack1Top.children.get(i));
            }
            stack2.push(stack1Top);
        }

        while (!stack2.isEmpty()) {
            ans.add(stack2.pop().val);
        }
        return ans;
    }
}
