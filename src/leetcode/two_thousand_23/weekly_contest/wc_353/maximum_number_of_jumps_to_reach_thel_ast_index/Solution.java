package leetcode.two_thousand_23.weekly_contest.wc_353.maximum_number_of_jumps_to_reach_thel_ast_index;

import java.util.LinkedList;
import java.util.Queue;

// nums = [1,3,6,4,1,2], target = 2

class Pair {
    public int first;
    public int second;
    public Pair(int first, int second) {
         this.first = first;
         this.second = second;
    }
}
public class Solution {
    // https://leetcode.com/contest/weekly-contest-353/problems/maximum-number-of-jumps-to-reach-the-last-index/
    // 6899. Maximum Number of Jumps to Reach the Last Index
    public int maximumJumps(int[] nums, int target) {
        Queue<Pair> nodes = new LinkedList<>();
        nodes.offer(new Pair(0, 0));
        int maxJump = -1;
        while(!nodes.isEmpty()) {
            Pair top = nodes.poll();

            int fromIdx = top.first;
            int so_far_jump = top.second;
            if(fromIdx == nums.length - 1) {
                maxJump = maxJump < so_far_jump ? so_far_jump : maxJump;
            } else {
                for(int i = fromIdx + 1; i < nums.length; i++) {
                    int difference = Math.abs(nums[fromIdx] - nums[i]);
                    if(difference <= target) {
                        nodes.offer(new Pair(i, (so_far_jump + 1)));
                    }
                }
            }
        }
        return maxJump;
    }
}
