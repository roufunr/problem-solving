package leetcode.two_thousand_24.bst.iterator;

import java.util.ArrayList;
import java.util.List;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class BSTIterator {
    private List<Integer> inorder;
    private int idx;

    public BSTIterator(TreeNode root) {
        if (root == null) {
            root = new TreeNode();
            root.val = -1;
        } else {
            TreeNode itr = root;
            while (itr != null) {
                if (itr.left == null) {
                    itr.left = new TreeNode();
                    itr.left.val = -1;
                    break;
                }
                itr = itr.left;
            }
        }
        inorder = new ArrayList<>();
        idx = 0;
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        inorder.add(node.val);
        inorderTraversal(node.right);
    }

    public int next() {
        if (hasNext()) {
            idx++;
            return inorder.get(idx);
        } else {
            return -1;
        }
    }

    public boolean hasNext() {
        return idx + 1 < inorder.size();
    }
}
