package leetcode.daily_challenge.november_24.minimum_obstacle_removal_to_reach_corner_28;

import java.util.*;

class Pair {
    public String node;
    public int distance;

    public Pair() {
        this.distance = 0;
    }

    public Pair(String node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class Solution {
    public int minimumObstacles(int[][] grid) {
        Map<String, Integer> distances = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                distances.put(i + "_" + j, Integer.MAX_VALUE);
            }
        }

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
        Pair initPair = new Pair();
        initPair.node = 0 + "_" + 0;
        if (grid[0][0] == 1) {
            distances.put(0 + "_" + 0, 1);
            initPair.distance = 1;
        } else {
            distances.put(0 + "_" + 0, 0);
            initPair.distance = 0;
        }
        queue.offer(initPair);
        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            int topX = Integer.parseInt(top.node.split("_")[0]);
            int topY = Integer.parseInt(top.node.split("_")[1]);
            int queueDist = top.distance;
            int soFarDist = distances.get(top.node);
            if (queueDist > soFarDist) {
                continue;
            }
            for (int[] dir : dirs) {
                int newX = topX + dir[0];
                int newY = topY + dir[1];
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                    continue;
                }
                String newNode = newX + "_" + newY;
                int throughDist = grid[newX][newY] == 1 ? 1 + top.distance : top.distance;
                if (throughDist < distances.get(newNode)) {
                    distances.put(newNode, throughDist);
                    queue.offer(new Pair(newNode, throughDist));
                }
            }
        }
        return distances.get((grid.length - 1) + "_" + (grid[0].length - 1));
    }
}