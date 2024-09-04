package leetcode.daily_challenge.may_to_july_24.find_winner;

public class SolutionIII {
    public int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
            System.err.println(ans);
        }
        return ans + 1;
    }
}
