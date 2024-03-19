package leetcode.two_thousand_24.binary_tree.lowest_common_ancestor;

import java.util.ArrayList;
import java.util.List;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    public List<TreeNode> path(TreeNode root, TreeNode node) {
        List<TreeNode> p = new ArrayList<>();
        TreeNode itrNode = root;
        while(itrNode != null) {
            TreeNode savedNode = itrNode;
            p.add(savedNode);
            if(itrNode.val == node.val) {
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
        for(int i = 0; i < p1.size(); i++) {
            if(p1.get(i) == p2.get(i)) {
                return p1.get(i);
            }
        }
        return null;
    }
}
