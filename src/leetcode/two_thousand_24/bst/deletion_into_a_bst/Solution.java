package leetcode.two_thousand_24.bst.deletion_into_a_bst;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private int findMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(node.val, findMin(node.left));
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int rightMin = findMin(root.right);
                root.val = rightMin;
                return deleteNode(root.right, rightMin);
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
