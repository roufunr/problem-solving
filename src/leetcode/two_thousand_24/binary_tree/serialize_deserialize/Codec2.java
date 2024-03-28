package leetcode.two_thousand_24.binary_tree.serialize_deserialize;

import java.util.ArrayList;
import java.util.List;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Codec2 {
    private List<Integer> inorder;
    private List<Integer> preorder;

    public Codec2() {
        inorder = new ArrayList<>();
        preorder = new ArrayList<>();
    }
    private void in(TreeNode node) {
        if(node == null) {
            return;
        }
        in(node.left);
        inorder.add(node.val);
        in(node.right);
    }

    private void pre(TreeNode node) {
        if(node == null) {
            return;
        }
        preorder.add(node.val);
        pre(node.left);
        pre(node.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        in(root);
        pre(root);
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer n : inorder) {
            stringBuilder.append("" + n + ",");
        }
        if(inorder.size() >= 1){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        stringBuilder.append("___");
        for(Integer n : preorder) {
            stringBuilder.append("" + n + ",");
        }
        if(inorder.size() >= 1){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootIdxInInorder = -1;
        for(int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                rootIdxInInorder = i;
                break;
            }
        }
        int[] leftInorder = new int[rootIdxInInorder];
        int[] rightInorder = new int[inorder.length - rootIdxInInorder - 1];
        int[] leftPreOrder = new int[leftInorder.length];
        int[] rightPreOrder = new int[rightInorder.length];
        for(int i = 0; i < leftInorder.length; i++) {
            leftInorder[i] = inorder[i];
            leftPreOrder[i] = preorder[i + 1];
        }
        int j = 0;
        for(int i = rootIdxInInorder + 1; i < inorder.length; i++) {
            rightInorder[j] = inorder[i];
            rightPreOrder[j] = preorder[leftPreOrder.length + j + 1];
            j++;
        }
        root.left = buildTree(leftPreOrder, leftInorder);
        root.right = buildTree(rightPreOrder, rightInorder);
        return root;
    }
    public TreeNode deserialize(String data) {
        String[] parts = data.split("___");
        if(parts.length == 2) {
            String[] inorderStr = parts[0].split(",");
            String[] preorderStr = parts[1].split(",");
            int[] inorderArr = new int[inorderStr.length];
            int[] preorderArr = new int[preorderStr.length];
            for(int i = 0; i < inorderArr.length; i++) {
                inorderArr[i] = Integer.parseInt(inorderStr[i]);
                preorderArr[i] = Integer.parseInt(preorderStr[i]);
            }
            return buildTree(preorderArr, inorderArr);
        } else {
            return null;
        }
    }
}
