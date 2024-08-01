package leetcode.two_thousand_24.dp.min_difficulty_of_a_job_schedule;

public class Runner {
    public static void main(String[] args) {
        int[] jobDifficulty = {11,111,22,222,33,333,44,444};
        int d = 6;
        new Solution().minDifficulty(jobDifficulty, d);
    }
}
