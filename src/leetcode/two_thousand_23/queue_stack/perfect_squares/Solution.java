package leetcode.two_thousand_23.queue_stack.perfect_squares;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numSquares(int n) {
        int startState = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(startState + "_" + startState);
        while (!queue.isEmpty()) {
            String poppedState = queue.poll();
            int dist = Integer.parseInt(poppedState.split("_")[0]);
            int val = Integer.parseInt(poppedState.split("_")[1]);
            if(val == n) {
                return dist;
            }
            for(int i = 1; val + i * i <= n ; i++) {
                int newVal = val + i * i;
                int newDist = dist + 1;
                queue.add(newDist + "_" + newVal);
            }

        }
        return -1;
    }
}
