package leetcode.daily_challenge.january_25.trapping_rain_water_ii_19;

import java.util.PriorityQueue;

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Cell> pq = new PriorityQueue<>();

        for (int i = 0; i < rows; i++) {
            pq.offer(new Cell(heightMap[i][0], i, 0));
            pq.offer(new Cell(heightMap[i][cols - 1], i, cols - 1));
            visited[i][0] = true;
            visited[i][cols - 1] = true;
        }

        for (int i = 0; i < cols; i++) {
            pq.offer(new Cell(heightMap[0][i], 0, i));
            pq.offer(new Cell(heightMap[rows - 1][i], rows - 1, i));
            visited[0][i] = true;
            visited[rows - 1][i] = true;
        }

        int totalWater = 0;
        int[] directions = {0, 1, 0, -1, 0};

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            for (int d = 0; d < 4; d++) {
                int newRow = current.row + directions[d];
                int newCol = current.col + directions[d + 1];

                if (isInBounds(newRow, newCol, rows, cols) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    int height = heightMap[newRow][newCol];
                    totalWater += Math.max(0, current.height - height);
                    pq.offer(new Cell(Math.max(height, current.height), newRow, newCol));
                }
            }
        }

        return totalWater;
    }

    private boolean isInBounds(int row, int col, int rows, int cols) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }

    private static class Cell implements Comparable<Cell> {
        int height, row, col;

        Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.height, other.height);
        }
    }
}
