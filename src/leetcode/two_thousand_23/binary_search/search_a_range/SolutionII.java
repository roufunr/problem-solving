package leetcode.two_thousand_23.binary_search.search_a_range;

public class SolutionII {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int[] ans = { -1, -1 };
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) {
            ans[0] = left;
        } else if (nums[right] == target) {
            ans[0] = right;
        }

        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[right] == target) {
            ans[1] = right;
        } else if (nums[left] == target) {
            ans[1] = left;
        }

        return ans;
    }
}