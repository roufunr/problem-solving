package leetcode.two_thousand_23.queue_stack.matrix_0_1;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    public int x;
    public int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    private void calculateDist(int x, int y, int[][] mat, int[][] dist) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<Pair> queue = new LinkedList<>();
        dist[x][y] = 0;
        visited[x][y] = true;
        queue.offer(new Pair(x, y));
        while(!queue.isEmpty()) {
            Pair front = queue.poll();
            if (front.x - 1 >= 0 && visited[front.x -1][front.y] == false) {
                if(mat[front.x - 1][front.y] != 0) {
                    visited[front.x - 1][front.y] = true;
                    dist[front.x -1][front.y] = dist[front.x][front.y] + 1 < dist[front.x -1][front.y] ?
                            dist[front.x][front.y] + 1 : dist[front.x -1][front.y];
                    queue.offer(new Pair(front.x - 1, front.y));
                }
            }
            if (front.x + 1 < mat.length && visited[front.x + 1][front.y] == false) {
                if(mat[front.x + 1][front.y] != 0) {
                    visited[front.x + 1][front.y] = true;
                    dist[front.x + 1][front.y] = dist[front.x][front.y] + 1 < dist[front.x + 1][front.y] ?
                            dist[front.x][front.y] + 1 : dist[front.x + 1][front.y];
                    queue.offer(new Pair(front.x + 1, front.y));
                }
            }
            if (front.y - 1 >= 0 && visited[front.x][front.y - 1] == false) {
                if(mat[front.x][front.y - 1] != 0) {
                    visited[front.x][front.y - 1] = true;
                    dist[front.x][front.y - 1] = dist[front.x][front.y] + 1 < dist[front.x][front.y - 1] ?
                            dist[front.x][front.y] + 1 : dist[front.x][front.y - 1];
                    queue.offer(new Pair(front.x, front.y - 1));
                }
            }
            if (front.y + 1 < mat[0].length && visited[front.x][front.y + 1] == false) {
                if(mat[front.x][front.y + 1] != 0) {
                    visited[front.x][front.y + 1] = true;
                    dist[front.x][front.y + 1] = dist[front.x][front.y] + 1 < dist[front.x][front.y + 1] ?
                            dist[front.x][front.y] + 1 : dist[front.x][front.y + 1];
                    queue.offer(new Pair(front.x, front.y + 1));
                }
            }
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        for(int i  = 0; i < dist.length; i++) {
            for(int j = 0; j < dist[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i  = 0; i < dist.length; i++) {
            for(int j = 0; j < dist[0].length; j++) {
                if(mat[i][j] == 0) {
                    calculateDist(i, j, mat, dist);
                }
            }
        }
        return dist;
    }
}
