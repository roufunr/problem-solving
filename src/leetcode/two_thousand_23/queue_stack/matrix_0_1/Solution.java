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
    private int calculateDist(int x, int y, int[][] mat) {
        if(mat[x][y] == 0) {
            return 0;
        }
        int[][] distance = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<Pair> queue = new LinkedList<>();
        distance[x][y] = 0;
        visited[x][y] = true;
        queue.offer(new Pair(x, y));
        while(!queue.isEmpty()) {
            Pair front = queue.poll();
            if (front.x - 1 >= 0
                    && visited[front.x -1][front.y] == false) {
                if(mat[front.x - 1][front.y] == 0) {
                    return distance[front.x][front.y] + 1;
                } else {
                    visited[front.x -1][front.y] = true;
                    distance[front.x -1][front.y] = distance[front.x][front.y] + 1;
                    queue.offer(new Pair(front.x - 1, front.y));
                }
            }
            if (front.x + 1 < mat.length
                    && visited[front.x + 1][front.y] == false) {
                if(mat[front.x + 1][front.y] == 0) {
                    return distance[front.x][front.y] + 1;
                } else {
                    visited[front.x + 1][front.y] = true;
                    distance[front.x + 1][front.y] = distance[front.x][front.y] + 1;
                    queue.offer(new Pair(front.x + 1, front.y));
                }
            }
            if (front.y - 1 >= 0
                    && visited[front.x][front.y - 1] == false) {
                if(mat[front.x][front.y - 1] == 0) {
                    return distance[front.x][front.y] + 1;
                } else {
                    visited[front.x][front.y - 1] = true;
                    distance[front.x][front.y - 1] = distance[front.x][front.y] + 1;
                    queue.offer(new Pair(front.x, front.y - 1));
                }
            }
            if (front.y + 1 < mat[0].length
                    && visited[front.x][front.y + 1] == false) {
                if(mat[front.x][front.y + 1] == 0) {
                    return distance[front.x][front.y] + 1;
                } else {
                    visited[front.x][front.y + 1] = true;
                    distance[front.x][front.y + 1] = distance[front.x][front.y] + 1;
                    queue.offer(new Pair(front.x, front.y + 1));
                }
            }
        }
        return 0;
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                ans[i][j] = calculateDist(i, j, mat);
            }
        }
        return ans;
    }
}
