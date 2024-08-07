package lc_others.closest_nodes_queries_in_a_binary_search_tree;

import java.util.*;
import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    private List<Integer> sorted;

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        sorted.add(node.val);
        inorder(node.right);
    }

    private List<Integer> binarySearch(int query) {
        int left = 0;
        int right = sorted.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted.get(mid) == query) {
                return new ArrayList<>(Arrays.asList(query, query));
            } else if (sorted.get(mid) > query) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new ArrayList<>(
                Arrays.asList(right >= 0 ? sorted.get(right) : -1, left < sorted.size() ? sorted.get(left) : -1));
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        sorted = new ArrayList<>();
        inorder(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int query : queries) {
            ans.add(binarySearch(query));
        }
        return ans;
    }
}