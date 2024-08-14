package leetcode.daily_challenge.august_24.find_k_th_smallest_pair_distance;



public class SolutionII {
    // accepted
    public int smallestDistancePair(int[] nums, int k) {
        int[] count = new int[1000000 + 1];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count[Math.abs(nums[j] - nums[i])]++;
            }
        }
        int c = 0;
        int ans = 0;
        for (int j = 0; j < count.length; j++) {
            if (c + count[j] >= k) {
                ans = j;
                break;
            }
            c += count[j];
        }
        return ans;
    }
}