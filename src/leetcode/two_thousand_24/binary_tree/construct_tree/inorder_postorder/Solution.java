package leetcode.two_thousand_24.binary_tree.construct_tree.inorder_postorder;
import leetcode.two_thousand_24.binary_tree.tree.*;
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int rootIdxInInorder = -1;
        for(int i = 0; i < inorder.length; i++) {
            if (postorder[postorder.length - 1] == inorder[i]) {
                rootIdxInInorder = i;
                break;
            }
        }
        int[] leftInorder = new int[rootIdxInInorder];
        int[] rightInorder = new int[inorder.length - rootIdxInInorder - 1];
        int[] leftPostOrder = new int[rootIdxInInorder];
        int[] rightPostOrder = new int[inorder.length - rootIdxInInorder - 1];
        for(int i = 0; i < leftInorder.length; i++) {
            leftInorder[i] = inorder[i];
            leftPostOrder[i] = postorder[i];
        }
        for(int i = rootIdxInInorder + 1; i < inorder.length; i++) {
            rightInorder[i - leftInorder.length - 1] = inorder[i];
            rightPostOrder[i - leftInorder.length - 1] = postorder[i - 1];
        }
        root.left = buildTree(leftInorder, leftPostOrder);
        root.right = buildTree(rightInorder, rightPostOrder);
        return root;
    }
}
