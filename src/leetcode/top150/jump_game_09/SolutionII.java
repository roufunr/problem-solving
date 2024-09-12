package leetcode.top150.jump_game_09;

public class SolutionII {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        int currentPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int n = nums[i];
            maxReachable = Math.max(currentPosition + n, maxReachable);
            if (currentPosition + 1 <= maxReachable) {
                currentPosition++;
            } else {
                return false;
            }
        }
        return true;
    }
}
