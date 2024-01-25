package leetcode.two_thousand_24.binary_tree.postorder;

import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        walk(root, ans);
        return ans;
    }
}