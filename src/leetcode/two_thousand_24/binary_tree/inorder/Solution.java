package leetcode.two_thousand_24.binary_tree.inorder;

import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        walk(root, ans);
        return ans;
    }
}
