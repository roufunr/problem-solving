package leetcode.daily_challenge.center_of_graph;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        set.add(edges[0][0]);
        set.add(edges[0][1]);
        for (int vertex : edges[1]) {
            if (set.contains(vertex)) {
                return vertex;
            }
        }
        return -1;
    }
}