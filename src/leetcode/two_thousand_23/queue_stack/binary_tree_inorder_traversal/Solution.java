package leetcode.two_thousand_23.queue_stack.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        stack.push(currentNode);
        while(!stack.isEmpty()) {
            while(currentNode != null) {
                currentNode = currentNode.left;
                if(currentNode != null) stack.push(currentNode);
            }
            TreeNode popNode = stack.pop();
            ans.add(popNode.val);
            currentNode = popNode.right;
            if(currentNode != null) stack.push(currentNode);
        }
        return ans;
    }
}

