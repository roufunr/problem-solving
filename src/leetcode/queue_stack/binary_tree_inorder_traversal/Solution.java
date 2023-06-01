package leetcode.queue_stack.binary_tree_inorder_traversal;

import java.util.*;

public class Solution {
    private void pushTree(Stack<TreeNode> stack, Set<TreeNode> visited, TreeNode node) {
        if(node.right != null && !visited.contains(node.right)) {
            stack.push(node.right);
            visited.add(node.right);
        }

        stack.push(node);
        visited.add(node);

        if(node.left != null  && !visited.contains(node.left)) {
            stack.push(node.left);
            visited.add(node.left);
        }

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        //https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1383/
        if(root == null) {
            return new ArrayList<>();
        }
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        pushTree(stack, visited, root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if((node.left == null || visited.contains(node.left))) {

                if(node.right != null && !visited.contains(node.right)) { // corner case
                    stack.push(node.right);
                    visited.add(node.right);
                }

                inorder.add(node.val);
            } else {
                pushTree(stack, visited, node);
            }
        }
        return inorder;
    }
}
