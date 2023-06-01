package leetcode.binary_search.find_k_closest_elements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    //https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
    private int getClosestIdx(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int leftElement = Integer.MAX_VALUE;
        int rightElement = Integer.MAX_VALUE;
        if(left < nums.length) {
            leftElement = nums[left];
        } else {
            return right;
        }
        if (right >= 0) {
            rightElement = nums[right];
        } else {
            return left;
        }

        int closestIdx = Math.abs(leftElement - target) < Math.abs(rightElement - target) ? left : right;
        return closestIdx;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int closest = getClosestIdx(arr, x);
        List<int[]> possibleNumbers = new ArrayList<>();
        int sum = 0;
        for(int i = (closest - k + 1); i <= (closest + k -1); i++) {
            if(i < 0 || i >= arr.length) {
                continue;
            }
            int diff = Math.abs(x - arr[i]);
            sum += diff;
            possibleNumbers.add(new int[]{i,sum});
        }

        int min = possibleNumbers.get(k - 1)[1];
        int minIdx = possibleNumbers.get(k - 1)[0];
        for(int i = k; i < possibleNumbers.size(); i++) {
            int diff = possibleNumbers.get(i)[1] - possibleNumbers.get(i - k)[1];
            if(min > diff) {
                min = diff;
                minIdx = possibleNumbers.get(i)[0];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = minIdx - k + 1; i <= minIdx; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
