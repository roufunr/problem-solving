package leetcode.daily_challenge.august_24.maximum_distance_in_arrays;

import java.util.*;

public class SolutionIII {
    // single pass solution without using priority queue and pair class
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDist = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            int dist1 = arrays.get(i).get(arrays.get(i).size() - 1) - min;
            int dist2 = max - arrays.get(i).get(0);
            maxDist = Math.max(maxDist, dist1);
            maxDist = Math.max(maxDist, dist2);

            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return maxDist;
    }
}