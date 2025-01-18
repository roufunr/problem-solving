package leetcode.daily_challenge.january_25.minimum_cost_to_make_at_least_one_valid_path_in_a_grid_18;

import java.util.*;


public class Solution {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int getDistance(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0});
        while(!deque.isEmpty()) {
            int[] pos = deque.pollFirst();
            if(pos[0] == grid.length - 1 && pos[1] == grid[0].length - 1) {
                break;
            }
            for(int k = 0; k < dir.length; k++) {
                int[] nPos = new int[] {pos[0] + dir[k][0], pos[1] + dir[k][1]};
                if(nPos[0] < 0 || nPos[0] >= grid.length || nPos[1] < 0 || nPos[1] >= grid[0].length) {
                    continue;
                } else {
                    int cost = grid[pos[0]][pos[1]] == (k + 1) ? 0 : 1;
                    if(distance[pos[0]][pos[1]] + cost < distance[nPos[0]][nPos[1]]) {
                        distance[nPos[0]][nPos[1]] = distance[pos[0]][pos[1]] + cost;
                        if(cost == 1) {
                            deque.offerLast(nPos);
                        } else {
                            deque.offerFirst(nPos);
                        }
                    }
                }
            }
        }
        return distance[distance.length - 1][distance[0].length - 1];
    }
    public int minCost(int[][] grid) {
        int dist = getDistance(grid);
        return dist;
    }
}