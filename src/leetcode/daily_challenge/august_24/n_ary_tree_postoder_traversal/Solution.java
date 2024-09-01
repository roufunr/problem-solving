package leetcode.daily_challenge.august_24.n_ary_tree_postoder_traversal;

import java.util.*;
public class Solution {
    private List<Integer> postOrderList;
    private void traverse(Node node) {
        if(node == null) {
            return;
        }
        for(Node child : node.children) {
            traverse(child);
        }
        postOrderList.add(node.val);
    }
    public List<Integer> postorder(Node root) {
        postOrderList = new ArrayList<>();
        traverse(root);
        return postOrderList;
    }
}