package leetcode.daily_challenge.may_to_july_24.create_binary_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leetcode.two_thousand_24.bst.TreeNode;

public class SolutionI {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childset = new HashSet<>();
        for (int[] description : descriptions) {
            if (!map.containsKey(description[0])) {
                map.put(description[0], new TreeNode(description[0]));
            }
            TreeNode childNode = map.containsKey(description[1]) ? map.get(description[1])
                    : new TreeNode(description[1]);
            map.put(description[1], childNode);
            if (description[2] == 1) {
                map.get(description[0]).left = childNode;
            } else {
                map.get(description[0]).right = childNode;
            }
            childset.add(description[1]);
        }
        for (Integer key : map.keySet()) {
            if (!childset.contains(key)) {
                return map.get(key);
            }
        }
        return null;
    }
}
