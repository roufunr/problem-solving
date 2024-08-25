package leetcode.daily_challenge.august_24.binary_tree_postorder;

import java.util.ArrayList;
import java.util.List;
import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private List<Integer> postOrderList;
    private void traverse(TreeNode node) {
        if(node == null) {
            return;
        }
        traverse(node.left);
        traverse(node.right);
        postOrderList.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrderList = new ArrayList<>();
        traverse(root);
        return postOrderList;
    }
}