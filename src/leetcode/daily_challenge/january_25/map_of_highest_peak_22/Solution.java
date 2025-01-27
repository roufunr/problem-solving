package leetcode.daily_challenge.january_25.map_of_highest_peak_22;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    private boolean isValid(int[] newPos, int[][] heights) {
        if (newPos[0] < 0) {
            return false;
        }
        if (newPos[0] >= heights.length) {
            return false;
        }
        if (newPos[1] < 0) {
            return false;
        }
        if (newPos[1] >= heights[0].length) {
            return false;
        }
        return true;
    }

    public int[][] highestPeak(int[][] isWater) {
        int[][] heights = new int[isWater.length][isWater[0].length];
        int[][] adj = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    visited.add(i + "_" + j);
                    heights[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int[] del : adj) {
                int[] newPos = new int[] { top[0] + del[0], top[1] + del[1] };
                if (isValid(newPos, heights) && !visited.contains(newPos[0] + "_" + newPos[1])) {
                    heights[newPos[0]][newPos[1]] = heights[top[0]][top[1]] + 1;
                    visited.add(newPos[0] + "_" + newPos[1]);
                    queue.offer(newPos);
                }
            }
        }
        return heights;
    }
}