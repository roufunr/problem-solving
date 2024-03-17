package leetcode.two_thousand_24.binary_tree.levelorder;

import java.util.*;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        levelMap.put(root, 0);
        int maxLevel = 0;
        ans.add(new ArrayList<>());
        ans.get(maxLevel).add(root.val);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.left != null) {
                queue.add(top.left);
                levelMap.put(top.left, levelMap.get(top) + 1);
                if (maxLevel < levelMap.get(top) + 1) {
                    maxLevel = levelMap.get(top) + 1;
                }
                if (maxLevel >= ans.size()) {
                    ans.add(new ArrayList<>());
                }
                ans.get(levelMap.get(top) + 1).add(top.left.val);
            }
            if (top.right != null) {
                queue.add(top.right);
                levelMap.put(top.right, levelMap.get(top) + 1);
                if (maxLevel < levelMap.get(top) + 1) {
                    maxLevel = levelMap.get(top) + 1;
                }
                if (maxLevel >= ans.size()) {
                    ans.add(new ArrayList<>());
                }
                ans.get(levelMap.get(top) + 1).add(top.right.val);
            }
        }
        return ans;
    }
}