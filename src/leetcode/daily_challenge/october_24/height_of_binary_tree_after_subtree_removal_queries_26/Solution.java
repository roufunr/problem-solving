package leetcode.daily_challenge.october_24.height_of_binary_tree_after_subtree_removal_queries_26;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private int currentMaxHeight = 0;
    private int[] heightAfterRemoval = new int[100 * 1000 + 1];

    private void preorder(TreeNode node, int currentHeight, boolean isReverse) {
        if(node == null) {
            return;
        }
        if(isReverse) {
            heightAfterRemoval[node.val] = Math.max(currentMaxHeight, heightAfterRemoval[node.val]);
            currentMaxHeight = Math.max(currentMaxHeight, currentHeight);
            preorder(node.right, currentHeight + 1, isReverse);
            preorder(node.left, currentHeight + 1, isReverse);
        } else {
            heightAfterRemoval[node.val] = currentMaxHeight;
            currentMaxHeight = Math.max(currentMaxHeight, currentHeight);
            preorder(node.left, currentHeight + 1, isReverse);
            preorder(node.right, currentHeight + 1, isReverse);
        }
    }
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        this.currentMaxHeight = 0;
        this.preorder(root, 0, false);
        this.currentMaxHeight = 0;
        this.preorder(root, 0, true);
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = heightAfterRemoval[queries[i]];
        }
        return ans;
    }
}