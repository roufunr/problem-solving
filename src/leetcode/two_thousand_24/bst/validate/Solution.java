package leetcode.two_thousand_24.bst.validate;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    private int findMin(TreeNode node) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = findMin(node.left);
        int rightMin = findMin(node.right);
        return leftMin < node.val ? (leftMin < rightMin ? leftMin : rightMin) : (node.val < rightMin ? node.val : rightMin);
    }

    private int findMax(TreeNode node) {
        if(node == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);
        return leftMax > node.val ? (leftMax > rightMax ? leftMax : rightMax) : (node.val > rightMax ? node.val : rightMax);
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left != null) {
            int leftMax = findMax(root.left);
            if(leftMax >= root.val) {
                return false;
            }
        }
        if(root.right != null) {
            int rightMin = findMin(root.right);
            if(rightMin <= root.val) {
                return false;
            }
        }
        
        return isValidBST(root.left) && isValidBST(root.right);
    }
}