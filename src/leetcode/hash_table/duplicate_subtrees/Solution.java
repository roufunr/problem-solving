package leetcode.hash_table.duplicate_subtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    private String postOrder(TreeNode node, HashMap<String, Integer> map, List<TreeNode> ans) {
        if(node == null) {
            return "*";
        }

        String treeInStr = node.val + "," + postOrder(node.left, map, ans) + "," + postOrder(node.right, map, ans) ;
        map.put(treeInStr, map.getOrDefault(treeInStr, 0) + 1);
        if(map.get(treeInStr) == 2) {
            ans.add(node);
        }
        return treeInStr;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        postOrder(root, map, ans);
        return ans;
    }
}
