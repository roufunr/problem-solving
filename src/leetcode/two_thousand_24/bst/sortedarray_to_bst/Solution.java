package leetcode.two_thousand_24.bst.sortedarray_to_bst;

import leetcode.two_thousand_24.bst.TreeNode;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    // 0 1 2 3
    // 1 3
    // 0 4
    //
    // 0 1 2 3 4
    public TreeNode sortedArrayToBST(int[] nums) {
        int middleIdx = nums.length / 2;
        TreeNode root = null;
        root = insertIntoBST(root, nums[middleIdx]);
        for (int i = 1; i <= middleIdx; i++) {
            int prevIdx = middleIdx - i;
            int nextIdx = middleIdx + i;
            if (prevIdx >= 0) {
                root = insertIntoBST(root, nums[prevIdx]);
            }
            if (nextIdx < nums.length) {
                root = insertIntoBST(root, nums[nextIdx]);
            }
        }
        return root;
    }
}
