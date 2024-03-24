package leetcode.two_thousand_24.binary_tree.lowest_common_ancestor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    public List<TreeNode> path(TreeNode root, TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.val == node.val) {
                break;
            }
            if (top.left != null) {
                parent.put(top.left, top);
                queue.offer(top.left);
            }
            if (top.right != null) {
                parent.put(top.right, top);
                queue.offer(top.right);
            }
        }
        List<TreeNode> p = new ArrayList<>();
        TreeNode itrNode = node;
        while (true) {
            p.add(itrNode);
            if (parent.containsKey(itrNode)) {
                itrNode = parent.get(itrNode);
            } else {
                break;
            }
        }

        Collections.reverse(p);
        return p;
    }

    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p1 = path(root, p);
        List<TreeNode> p2 = path(root, q);
        List<TreeNode> smallList = p1.size() <= p2.size() ? p1 : p2;
        List<TreeNode> largeList = p1.size() > p2.size() ? p1 : p2;
        for (int i = smallList.size() - 1; i >= 0; i--) {
            if (smallList.get(i) == largeList.get(i)) {
                return smallList.get(i);
            }
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            return p;
        }
        if (root.val == q.val) {
            return q;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return root;
        }
    }
}
