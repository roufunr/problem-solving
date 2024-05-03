package leetcode.two_thousand_24.bst.sortedarray_to_bst;

import leetcode.two_thousand_24.bst.TreeNode;

public class SolutionV3 {
    public TreeNode insertIntoBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = insertIntoBST(nums, start, mid - 1);
        newNode.right = insertIntoBST(nums, mid + 1, end);
        return newNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = insertIntoBST(nums, 0, nums.length - 1);
        return root;
    }
}
