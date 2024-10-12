package leetcode.daily_challenge.october_24.divide_intervals_into_minimum_number_of_groups_12;

import java.util.*;
class Edge {
    public int val;
    public boolean start;
    public Edge(int val, int i) {
        if(i == 0) {
            start = true;
        } else {
            start = false;
        }
        this.val = val;
    }
}

public class Solution {
    public int minGroups(int[][] intervals) {
        Edge[] edges = new Edge[intervals.length * 2];
        int i = 0;
        for(int[] interval : intervals) {
            edges[i++] = new Edge(interval[0], 0);
            edges[i++] = new Edge(interval[1], 1);
        }
        Arrays.sort(edges, (x, y) -> {
            if (x.val == y.val) {
                if (x.start == true) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return x.val - y.val;
            }
        });

        int currentGroup = 0;
        int maxGroup = Integer.MIN_VALUE;
        for(Edge edge: edges) {
            if(edge.start) {
                currentGroup++;
            } else {
                currentGroup--;
            }
            maxGroup = Math.max(currentGroup, maxGroup);
        }
        return maxGroup;
    }
}