package leetcode.daily_challenge.february_25.find_the_number_of_distinc_colors_among_the_balls_07;

import java.util.*;

public class Solution {

    // public int[] queryResults(int limit, int[][] queries) {
    //     int n = queries.length;
    //     int[] result = new int[n];
    //     Map<Integer, Integer> colorMap = new HashMap<>();
    //     Map<Integer, Integer> ballMap = new HashMap<>();

    //     // Iterate through queries
    //     for (int i = 0; i < n; i++) {
    //         // Extract ball label and color from query
    //         int ball = queries[i][0];
    //         int color = queries[i][1];

    //         // Check if ball is already colored
    //         if (ballMap.containsKey(ball)) {
    //             // Decrement count of the previous color on the ball
    //             int prevColor = ballMap.get(ball);
    //             colorMap.put(prevColor, colorMap.get(prevColor) - 1);

    //             // If there are no balls with previous color left, remove color from color map
    //             if (colorMap.get(prevColor) == 0) {
    //                 colorMap.remove(prevColor);
    //             }
    //         }
    //         // Set color of ball to the new color
    //         ballMap.put(ball, color);

    //         // Increment the count of the new color
    //         colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

    //         result[i] = colorMap.size();
    //     }
    //     return result;
    // }

    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colorCountMap = new HashMap<>();
        Map<Integer, Integer> positionColorMap = new HashMap<>();
        int[] ans = new int[queries.length];
        int idx = 0;
        for(int[] query : queries) {
            if(positionColorMap.containsKey(query[0])) {
                int prevColor = positionColorMap.get(query[0]);
                if(prevColor != query[1]) {
                    colorCountMap.put(query[1], colorCountMap.getOrDefault(query[1], 0) + 1);
                    if(colorCountMap.get(prevColor) == 1) {
                        colorCountMap.remove(prevColor);
                    } else {
                        colorCountMap.put(prevColor, colorCountMap.get(query[1]) - 1);
                    }
                }
            } else {
                colorCountMap.put(query[1], colorCountMap.getOrDefault(query[1], 0) + 1);
            }
            positionColorMap.put(query[0], query[1]);
            ans[idx] = colorCountMap.size();
            idx++;
        }
        return ans;
    }
}