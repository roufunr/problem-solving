package leetcode.daily_challenge.october_24.longest_square_streak_in_an_array_28;
import java.util.*;
public class Solution {

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> processedNumbers = new HashSet<>();
        int longestStreak = 0;
        for (int current : nums) {
            if (processedNumbers.contains(current)) continue;

            int streak = current;
            int streakLength = 1;
            while (true) {
                if ((long) streak * (long) streak > 1e5) break;
                if (binarySearch(nums, streak * streak)) {
                    streak *= streak;
                    processedNumbers.add(streak);
                    streakLength++;
                } else {
                    break;
                }
            }
            longestStreak = Math.max(longestStreak, streakLength);
        }
        return longestStreak < 2 ? -1 : longestStreak;
    }
    private boolean binarySearch(int[] nums, int target) {
        if (target < 0) return false;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}