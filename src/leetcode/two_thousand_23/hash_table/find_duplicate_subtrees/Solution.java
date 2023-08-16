package leetcode.two_thousand_23.hash_table.find_duplicate_subtrees;
import java.util.*;
public class Solution {
    private String traverse(TreeNode node, Map<String, List<TreeNode>> map) {
        if(node == null) {
            return "";
        }
        String subTreeString = "L" + traverse(node.left, map) + node.val + "R" + traverse(node.right, map);
        if(map.containsKey(subTreeString)) {
            map.get(subTreeString).add(node);
        } else {
            List<TreeNode> treeNodeList = new ArrayList<>();
            treeNodeList.add(node);
            map.put(subTreeString, treeNodeList);
        }
        return subTreeString;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        traverse(root, map);
        List<TreeNode> ans = new ArrayList<>();
        for(Map.Entry<String, List<TreeNode>> entry : map.entrySet()) {
            if(entry.getValue().size() > 1) {
                ans.add(entry.getValue().get(0));
            }
        }
        return ans;
    }
}
