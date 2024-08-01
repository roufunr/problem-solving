package leetcode.daily_challenge.may_to_july_24.number_of_good_leafs_pair;

import java.util.*;
import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private List<TreeNode> leafs = new ArrayList<>();
    private Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    private int ans = 0;
    private int distance;

    private void findLeaf(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leafs.add(node);
        }
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        if (parent != null && !graph.containsKey(parent)) {
            graph.put(parent, new ArrayList<>());
        }
        if (parent != null) {
            graph.get(parent).add(node);
        }
        if (parent != null) {
            graph.get(node).add(parent);
        }
        ;
        findLeaf(node.left, node);
        findLeaf(node.right, node);
    }

    private void bfs(TreeNode source) {
        Map<TreeNode, Integer> dist = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        dist.put(source, 0);
        queue.offer(source);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (dist.get(top) > distance) {
                return;
            }
            if (top != source && top.left == null && top.right == null) {
                ans++;
            }
            for (TreeNode next : graph.get(top)) {
                if (!dist.containsKey(next)) {
                    dist.put(next, dist.get(top) + 1);
                    queue.offer(next);
                }
            }
        }
    }

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        findLeaf(root, null);
        for (TreeNode leaf : leafs) {
            bfs(leaf);
        }
        return ans / 2;
    }
}