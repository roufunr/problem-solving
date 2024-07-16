package leetcode.daily_challenge.step_by_step_direction_in_binary_tree;

import java.util.*;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private Map<Integer, List<String>> graph = new HashMap<>();
    private String ans;
    private int dest;

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            if (!graph.containsKey(node.val)) {
                graph.put(node.val, new ArrayList<>());
            }
            if (!graph.containsKey(node.left.val)) {
                graph.put(node.left.val, new ArrayList<>());
            }
            graph.get(node.val).add(node.left.val + "_L");
            graph.get(node.left.val).add(node.val + "_U");
        }
        if (node.right != null) {
            if (!graph.containsKey(node.val)) {
                graph.put(node.val, new ArrayList<>());
            }
            if (!graph.containsKey(node.right.val)) {
                graph.put(node.right.val, new ArrayList<>());
            }
            graph.get(node.val).add(node.right.val + "_R");
            graph.get(node.right.val).add(node.val + "_U");
        }
        traverse(node.left);
        traverse(node.right);

    }

    private void search(int currentVal, List<Character> path, Set<Integer> visited) {
        if (currentVal == dest) {
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
                sb.append(c);
            }
            ans = sb.toString();
            return;
        }
        visited.add(currentVal);
        for (String next : graph.get(currentVal)) {
            String[] parts = next.split("_");
            int nodeVal = Integer.parseInt(parts[0]);
            if (visited.contains(nodeVal)) {
                continue;
            }
            path.add(parts[1].charAt(0));
            search(nodeVal, path, visited);
            path.remove(path.size() - 1);
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.dest = destValue;
        traverse(root);
        List<Character> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        search(startValue, path, visited);
        return ans;
    }
}
