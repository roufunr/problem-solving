package leetcode.two_thousand_23.hash_table.find_duplicate_subtrees;
import java.util.*;
public class Solution {
    private void traverser(TreeNode node, Map<TreeNode, Integer> map) {
        if(node == null) {
            return;
        }
        if(map.containsKey(node)) {
            map.put(node, map.get(node) + 1);
        } else {
            map.put(node, 1);
        }

        traverser(node.left, map);
        traverser(node.right, map);
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        traverser(root, map);
        List<TreeNode> ans = new ArrayList<>();
        for(Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
