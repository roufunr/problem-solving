package leetcode.two_thousand_23.queue_stack.number_of_islands;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    private void startBFS(int i, int j, char[][] grid, boolean[][] visited) {
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(i + "_" + j);
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            String[] position = queue.poll().split("_");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);

            if(x-1 >= 0 && grid[x-1][y] == '1' && visited[x-1][y] == false) { // left
                queue.offer((x-1) + "_" + y);
                visited[x-1][y] = true;
            }

            if(x+1 < grid.length && grid[x+1][y] == '1' && visited[x+1][y] == false) { //right
                queue.offer((x+1) + "_" + y);
                visited[x+1][y] = true;
            }

            if(y-1 >= 0 && grid[x][y-1] == '1' && visited[x][y-1] == false) { // up
                queue.offer((x) + "_" + (y-1));
                visited[x][y-1] = true;
            }

            if(y + 1 < grid[0].length && grid[x][y + 1] == '1' && visited[x][y + 1] == false) {
                queue.offer((x) + "_" + (y + 1));
                visited[x][y + 1] = true;
            }

        }
    }

    private void startDFS(int i, int j, char[][] grid, boolean[][] visited) {
        Stack<String> stack = new Stack<>();
        stack.push(i + "_" + j);
        visited[i][j] = true;
        while(!stack.isEmpty()) {
            String[] position = stack.pop().split("_");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);

            if(x-1 >= 0 && grid[x-1][y] == '1' && visited[x-1][y] == false) { // left
                stack.push((x-1) + "_" + y);
                visited[x-1][y] = true;
            }

            if(x+1 < grid.length && grid[x+1][y] == '1' && visited[x+1][y] == false) { //right
                stack.push((x+1) + "_" + y);
                visited[x+1][y] = true;
            }

            if(y-1 >= 0 && grid[x][y-1] == '1' && visited[x][y-1] == false) { // up
                stack.push((x) + "_" + (y-1));
                visited[x][y-1] = true;
            }

            if(y + 1 < grid[0].length && grid[x][y + 1] == '1' && visited[x][y + 1] == false) {
                stack.push((x) + "_" + (y + 1));
                visited[x][y + 1] = true;
            }
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islandCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && visited[i][j] == false) {
                    islandCount++;
                    startDFS(i, j, grid, visited);
                }
            }
        }
        return islandCount;
    }
}
