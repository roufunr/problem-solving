package leetcode.two_thousand_24.bst.sortedarray_to_bst;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    // in terms of memory this solution is 23% better than V3 and 28% better than V1
    // V0 is incorrect solution

    private int[] nums;

    public TreeNode insertIntoBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = insertIntoBST(start, mid - 1);
        newNode.right = insertIntoBST(mid + 1, end);
        return newNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        TreeNode root = insertIntoBST(0, nums.length - 1);
        return root;
    }
}
