package leetcode.two_thousand_24.bst.sortedarray_to_bst;

import java.util.HashSet;
import java.util.Set;

import leetcode.two_thousand_24.bst.TreeNode;

public class SolutionV1 {
    private Set<Integer> set;

    public SolutionV1() {
        set = new HashSet<>();
    }

    public TreeNode insertIntoBST(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        if (set.contains(mid) || mid < 0 || mid >= nums.length) {
            return null;
        }
        set.add(mid);
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
