package leetcode.daily_challenge.april_25.lowest_common_ancestor_of_deepest_leaves_04;

import leetcode.two_thousand_24.bst.TreeNode;

public class Pair  {
    private TreeNode key;
    private Integer value;
    public Pair(TreeNode key, Integer value) {
        this.key = key;
        this.value = value;
    }
    public TreeNode getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
}
