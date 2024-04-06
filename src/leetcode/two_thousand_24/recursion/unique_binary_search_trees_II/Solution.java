package leetcode.two_thousand_24.recursion.unique_binary_search_trees_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.two_thousand_24.binary_tree.tree.TreeNode;

public class Solution {
    private List<TreeNode> generate(int startNode, int endNode, Map<String, List<TreeNode>> map) {
        List<TreeNode> rootList = new ArrayList<>();
        if(startNode > endNode) {
            rootList.add(null);
            return rootList;
        }
        String key = startNode + "_" + endNode;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        for(int i = startNode; i <= endNode; i++) {
            List<TreeNode> leftTreeRoots = generate(startNode, i-1, map);
            List<TreeNode> rightTreeRoots = generate(i + 1, endNode, map);
            for(TreeNode leftTreeRoot: leftTreeRoots) {
                for(TreeNode rightTreeRoot: rightTreeRoots) {
                    TreeNode root = new TreeNode(i, leftTreeRoot, rightTreeRoot);
                    rootList.add(root);
                }
            }
        }
        map.put(key, rootList);
        return rootList;
    }
    public List<TreeNode> generateTrees(int n) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        return generate(1, n, map);
    }
}
