package leetcode.two_thousand_24.binary_tree.inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.two_thousand_24.binary_tree.tree.*;

public class Solution {
    private void walk(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        walk(node.left, list);
        list.add(node.val);
        walk(node.right, list);
    }

    private void walk_v1(TreeNode root, List<Integer> list) { // iterative approach
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode current = root.left;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.pop();
            list.add(top.val);
            current = top.right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        walk_v1(root, ans);
        return ans;
    }

}
