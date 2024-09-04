package leetcode.daily_challenge.may_to_july_24.find_winner;


import java.util.LinkedList;
import java.util.Queue;

public class SolutionII { // queue based solution
    public int findTheWinner(int n, int k) {
        Queue<Integer> values = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            values.offer(i + 1);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < k - 1; j++) {
                values.offer(values.poll());
            }
            values.poll();
        }
        return values.poll();
    }
}
