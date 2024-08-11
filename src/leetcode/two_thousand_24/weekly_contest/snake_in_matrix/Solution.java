package leetcode.two_thousand_24.weekly_contest.snake_in_matrix;

import java.util.*;

public class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("RIGHT", new ArrayList<>(Arrays.asList(0, 1)));
        map.put("DOWN", new ArrayList<>(Arrays.asList(1, 0)));
        map.put("LEFT", new ArrayList<>(Arrays.asList(0, -1)));
        map.put("UP", new ArrayList<>(Arrays.asList(-1, 0)));
        int x = 0;
        int y = 0;
        for (String command : commands) {
            x += map.get(command).get(0);
            y += map.get(command).get(1);
        }
        return x * n + y;
    }
}