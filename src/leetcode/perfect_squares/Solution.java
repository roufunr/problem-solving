package leetcode.perfect_squares;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        queue.add(0);
        visited.put(0, 0);
        while (!queue.isEmpty()) {
            int curNum = queue.remove();
            int stateCount = visited.get(curNum);
            int remainingNum = n - curNum;
            for(int i = 1; i * i <= remainingNum; i++) {
                int newNum = curNum + i * i;
                if(visited.containsKey(newNum)) {
                    continue;
                } else if(newNum == n) {
                    return stateCount + 1;
                } else {
                    queue.add(newNum);
                    visited.put(newNum, stateCount + 1);
                }
            }
        }
        return -1;
    }
}
