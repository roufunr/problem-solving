package leetcode.two_thousand_23.binary_search.find_k_closest_elements;

import java.util.*;

public class Solution {

    private int findClosestIdx(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int closest_idx = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                closest_idx = mid;
                break;
            } else if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (closest_idx == -1) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                closest_idx = left;
            } else {
                closest_idx = right;
            }
        }
        return closest_idx;
    }

    public List<Integer> findClosestElements_vI(int[] arr, int k, int x) {
        int closest_idx = findClosestIdx(arr, x);
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[closest_idx]);
        int left = closest_idx - 1;
        int right = closest_idx + 1;
        while (ans.size() < k) {
            int leftElementOffset = left < 0 ? Integer.MAX_VALUE : Math.abs(arr[left] - x);
            int rightElementOffset = right >= arr.length ? Integer.MAX_VALUE : Math.abs(arr[right] - x);
            if (leftElementOffset < rightElementOffset) {
                ans.add(arr[left]);
                left--;
            } else if (leftElementOffset > rightElementOffset) {
                ans.add(arr[right]);
                right++;
            } else {
                if (arr[left] < arr[right]) {
                    ans.add(arr[left]);
                    left--;
                } else {
                    ans.add(arr[right]);
                    right++;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int closest_idx = findClosestIdx(arr, x);
        List<Integer> ans = new ArrayList<>();
        int occupied = 1;
        int left = closest_idx - 1;
        int right = closest_idx + 1;
        while (occupied < k) {
            int leftElementOffset = left < 0 ? Integer.MAX_VALUE : Math.abs(arr[left] - x);
            int rightElementOffset = right >= arr.length ? Integer.MAX_VALUE : Math.abs(arr[right] - x);
            if (leftElementOffset < rightElementOffset) {
                occupied++;
                left--;
            } else if (leftElementOffset > rightElementOffset) {
                occupied++;
                right++;
            } else {
                if (arr[left] < arr[right]) {
                    occupied++;
                    left--;
                } else {
                    occupied++;
                    right++;
                }
            }
        }
        for (int i = left + 1; i <= (left + k); i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
