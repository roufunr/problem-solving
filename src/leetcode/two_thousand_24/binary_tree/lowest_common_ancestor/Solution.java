package leetcode.two_thousand_24.binary_tree.lowest_common_ancestor;

import java.util.ArrayList;
import java.util.List;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    public List<TreeNode> path(TreeNode root, TreeNode node) {
        List<TreeNode> p = new ArrayList<>();
        TreeNode itrNode = root;
        while (itrNode != null) {
            TreeNode savedNode = itrNode;
            p.add(savedNode);
            if (itrNode.val == node.val) {
                break;
            } else if (itrNode.val > node.val) {
                itrNode = itrNode.right;
            } else {
                itrNode = itrNode.left;
            }
        }
        return p;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p1 = path(root, p);
        List<TreeNode> p2 = path(root, q);
        List<TreeNode> smallList = p1.size() < p2.size() ? p1 : p2;
        List<TreeNode> largeList = p1.size() > p2.size() ? p1 : p2;
        for (int i = 0; i < smallList.size(); i++) {
            if (smallList.get(i) != largeList.get(i)) {
                return smallList.get(i - 1);
            }
        }

        if (smallList.size() == 1) {
            return smallList.get(0);
        } else {
            return smallList.get(smallList.size() - 1);
        }
    }
}
