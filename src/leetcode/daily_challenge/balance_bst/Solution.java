package leetcode.daily_challenge.balance_bst;

import java.util.*;
import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private List<Integer> elements;

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        elements.add(node.val);
        inorder(node.right);
    }

    private TreeNode constructTree(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(elements.get(mid));
        node.left = constructTree(start, mid - 1);
        node.right = constructTree(mid + 1, end);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        elements = new ArrayList<>();
        inorder(root);
        Collections.sort(elements);
        return constructTree(0, elements.size() - 1);
    }
}