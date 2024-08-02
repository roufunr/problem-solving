package leetcode.daily_challenge.august_24.min_swap_to_group_all_1s;

import java.util.PriorityQueue;

public class Solution {
    public int minSwaps(int[] nums) { 
        // int countOne = 0;
        // for(int n : nums) {
        // if(n == 1) {
        // countOne++;
        // }
        // }

        PriorityQueue<Integer> countZero = new PriorityQueue<>();
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 1 && nums[i] == 0) {
                idx = i;
                break;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = (idx + i) % nums.length;
            if (nums[j] == 0) {
                count++;
            } else {
                if (count > 0) {
                    System.out.println(count);
                    countZero.offer(count);
                }
                count = 0;
            }
        }
        int swapCount = 0;
        for (int i = 0; i < countZero.size() - 1; i++) {
            swapCount += countZero.poll();
        }
        return swapCount;
    }
}