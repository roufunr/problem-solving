package leetcode.hash_table.duplicate_subtrees;

public class Runner {
    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2, four, null);
        TreeNode three = new TreeNode(3, two, four);
        TreeNode one = new TreeNode(1, two, three);

        new Solution().findDuplicateSubtrees(one);
    }
}
