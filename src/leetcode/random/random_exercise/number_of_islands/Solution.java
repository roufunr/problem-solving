package leetcode.random.random_exercise.number_of_islands;
import java.util.*;
class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void visit(char[][] grid, int x, int y, Set<String> visited) {
        visited.add(x + "_" + y);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] top = queue.poll();
            int topX = top[0];
            int topY = top[1];
            for(int[] dir : dirs) {
                int newX = topX + dir[0];
                int newY = topY + dir[1];
                if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                    continue;
                }
                if(grid[newX][newY] == '0' || visited.contains(newX + "_" + newY)) {
                    continue;
                }
                visited.add(newX + "_" + newY);
                queue.offer(new int[]{newX, newY});
            }
        }

    }

    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0' || visited.contains(i + "_" + j)) {
                    continue;
                }
                visit(grid, i, j, visited);
                count++;
            }
        }
        return count;
    }
}