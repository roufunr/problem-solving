package leetcode.daily_challenge.find_winner;

import java.util.LinkedList;
import java.util.Queue;

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
