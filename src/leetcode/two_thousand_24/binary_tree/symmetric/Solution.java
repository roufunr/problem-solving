package leetcode.two_thousand_24.binary_tree.symmetric;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    String treeInString(TreeNode node) {
        if (node == null) {
            return "";
        }
        return node.val + "|" + treeInString(node.left) + "|" + treeInString(node.right);
    }

    String getReverse(String input) {
        byte[] strAsByteArray = input.getBytes();
        byte[] result = new byte[strAsByteArray.length];
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        return new String(result);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            String lefString = treeInString(root.left);
            String rightString = treeInString(root.right);
            return lefString.equals(getReverse(rightString));
        }
        return false;
    }
}
