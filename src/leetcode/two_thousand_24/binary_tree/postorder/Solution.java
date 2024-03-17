package leetcode.two_thousand_24.binary_tree.postorder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Stack;

import leetcode.two_thousand_24.binary_tree.tree.*;

public class Solution {
    private void walk(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        walk(node.left, list);
        walk(node.right, list);
        list.add(node.val);
    }

    private void walk_v1(TreeNode root, List<Integer> list) { // iterative approach
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> explored = new HashSet<>();
        stack.push(root);
        TreeNode current = root.left;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.peek();
            if (top.right != null && !explored.contains(top.right)) {
                current = top.right;
            } else {
                list.add(top.val);
                explored.add(top);
                stack.pop();
            }
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        walk_v1(root, ans);
        return ans;
    }
}