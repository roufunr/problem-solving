package leetcode.two_thousand_24.binary_tree.construct_tree.inorder_preorder;
import leetcode.two_thousand_24.binary_tree.tree.*;
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
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
}
