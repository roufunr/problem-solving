package leetcode.two_thousand_24.weekly_contest.count_the_number_of_good_nodes;

import java.util.*;

class TreeNode {
    public int val;
    public List<TreeNode> children;

    public TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class Solution {
    private int ans = 0;
    private List<Set<Integer>> adj;

    private void constructGraph(int[][] edges) {
        int n = edges.length + 1;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    }

    private TreeNode constructTree() {
        TreeNode root = new TreeNode(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            for (Integer nei : adj.get(top.val)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    TreeNode childNode = new TreeNode(nei);
                    top.children.add(childNode);
                    queue.offer(childNode);
                }
            }
        }
        return root;
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if(node.children.size() == 0) {
            ans++;
            return 1;
        }
        Set<Integer> allChildCount = new HashSet<>();
        int total = 1;
        for (TreeNode child : node.children) {
            int c = count(child);
            allChildCount.add(c);
            total += c;
        }
        if (allChildCount.size() == 1) {
            ans++;
        }
        return total;
    }

    public int countGoodNodes(int[][] edges) {
        this.constructGraph(edges);
        TreeNode root = this.constructTree();
        count(root);
        return ans;
    }
}