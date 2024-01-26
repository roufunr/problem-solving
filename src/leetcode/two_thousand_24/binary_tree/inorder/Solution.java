package leetcode.two_thousand_24.binary_tree.inorder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        visited.add(root);
        while (!stack.isEmpty()) {
            TreeNode topNode = stack.pop();
            list.add(topNode.val);
            if (topNode.right != null) { // so that left item is popped first
                stack.push(topNode.right);
                visited.add(topNode.right);
            }
            if (topNode.left != null) {
                stack.push(topNode.left);
                visited.add(topNode.left);
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        walk(root, ans);
        return ans;
    }
}
