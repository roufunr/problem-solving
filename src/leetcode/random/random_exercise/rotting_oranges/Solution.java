package leetcode.random.random_exercise.rotting_oranges;
import java.util.*;
class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean isValid(int x, int y, int[][] grid) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        } 
        if(grid[x][y] == 0) {
            return false;
        }
        return true;
    }
    private void traverse(int[][] grid, Queue<String> queue, Map<String, Integer> timeMap) {
        while(!queue.isEmpty()) {
            String top = queue.poll();
            int topX = Integer.parseInt(top.split("_")[0]);
            int topY = Integer.parseInt(top.split("_")[1]);
            int time = timeMap.get(top);
            for(int[] dir : dirs) {
                int newX = topX + dir[0];
                int newY = topY + dir[1];
                
                if(!isValid(newX, newY, grid)) {
                    continue;
                }
                String orangePosition = newX + "_" + newY;
                if(timeMap.get(orangePosition) > time + 1) {
                    timeMap.put(orangePosition, time + 1);
                    queue.offer(orangePosition);
                }
            }
        }
    }
    public int orangesRotting(int[][] grid) {
        Map<String, Integer> timeMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    continue;
                } else if(grid[i][j] == 1) {
                    timeMap.put(i + "_" + j, Integer.MAX_VALUE);
                } else {
                    timeMap.put(i + "_" + j, 0);
                    queue.offer(i + "_" + j);
                }
            }
        }
        traverse(grid, queue, timeMap);
        int max = 0;
        for(String position : timeMap.keySet()) {
            if(timeMap.get(position) == Integer.MAX_VALUE) {
                return -1;
            } else {
                max = Math.max(max, timeMap.get(position));
            }
        }
        return max;
    }
}