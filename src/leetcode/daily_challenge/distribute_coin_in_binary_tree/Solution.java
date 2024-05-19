package leetcode.daily_challenge.distribute_coin_in_binary_tree;

import leetcode.two_thousand_24.bst.TreeNode;

class pair {
    public int treesize;
    public int coin;
    public pair(int treesize, int coin) {
        this.treesize = treesize;
        this.coin = coin;
    }
}

public class Solution {
    private int result;
    private pair helper(TreeNode node) {
        if(node == null) {
            return new pair(0, 0);
        }
        pair leftSubTreePair = helper(node.left);
        pair rightSubTreePair = helper(node.right);
        int treesize = leftSubTreePair.treesize + 1 + rightSubTreePair.treesize;
        int coin = leftSubTreePair.coin + node.val + rightSubTreePair.coin;
        result += Math.abs(treesize - coin);
        return new pair(treesize, coin);
    }
    public int distributeCoins(TreeNode root) {
        result = 0;
        helper(root);
        return result;
    }
}
