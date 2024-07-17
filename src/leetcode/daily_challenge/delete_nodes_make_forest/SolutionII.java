package leetcode.daily_challenge.delete_nodes_make_forest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.two_thousand_24.bst.TreeNode;

public class SolutionII { // without p map
    private void delete(TreeNode node, TreeNode parent, Set<Integer> dset, Set<TreeNode> roots) {
        if (node == null) {
            return;
        }
        delete(node.left, node, dset, roots);
        delete(node.right, node, dset, roots);
        if (dset.contains(node.val)) {
            if (roots.contains(node)) {
                roots.remove(node);
            }
            if (node.left != null)
                roots.add(node.left);
            if (node.right != null)
                roots.add(node.right);
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } else if (parent.right == node) {
                    parent.right = null;
                }
            }
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        Set<Integer> set = new HashSet<>();
        for (int n : to_delete) {
            set.add(n);
        }
        Set<TreeNode> roots = new HashSet<>();
        roots.add(root);
        delete(root, null, set, roots);
        return new ArrayList<>(roots);
    }
}
