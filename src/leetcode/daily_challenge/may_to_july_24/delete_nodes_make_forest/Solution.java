package leetcode.daily_challenge.may_to_july_24.delete_nodes_make_forest;

import leetcode.two_thousand_24.bst.TreeNode;
import java.util.*;

public class Solution { // solved with P Map
    private Map<Integer, TreeNode> pMap = new HashMap<>();

    private void storeInPMap(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left != null) {
            pMap.put(left.val, node);
            storeInPMap(left);
        }
        if (right != null) {
            pMap.put(right.val, node);
            storeInPMap(right);
        }
    }

    private void delete(TreeNode node, Set<Integer> dSet, Set<TreeNode> roots) {
        if (node == null) {
            return;
        }
        if (dSet.contains(node.val)) {
            if (roots.contains(node)) {
                roots.remove(node);
            }
            if (node.left != null) {
                roots.add(node.left);
                delete(node.left, dSet, roots);
            }
            if (node.right != null) {
                roots.add(node.right);
                delete(node.right, dSet, roots);
            }
            TreeNode parent = pMap.get(node.val);
            if (parent != null && parent.left == node) {
                parent.left = null;
            } else if (parent != null && parent.right == node) {
                parent.right = null;
            }
        } else {
            delete(node.left, dSet, roots);
            delete(node.right, dSet, roots);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        storeInPMap(root);
        Set<Integer> set = new HashSet<>();
        for (int n : to_delete) {
            set.add(n);
        }
        Set<TreeNode> roots = new HashSet<>();
        roots.add(root);
        delete(root, set, roots);
        return new ArrayList<>(roots);
    }
}