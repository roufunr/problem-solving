package leetcode.daily_challenge.august_24.maximum_distance_in_arrays;
import java.util.*;

public class SolutionII {
    private int maxToMin(List<List<Integer>> arrays) {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < arrays.size(); i++) {
            if (max < arrays.get(i).get(arrays.get(i).size() - 1)) {
                max = arrays.get(i).get(arrays.get(i).size() - 1);
                maxIdx = i;
            }
        }
        int maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.size(); i++) {
            if (i == maxIdx)
                continue;
            maxDist = Math.max(maxDist, max - arrays.get(i).get(0));
        }
        return maxDist;
    }

    private int minToMax(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < arrays.size(); i++) {
            if (min > arrays.get(i).get(0)) {
                min = arrays.get(i).get(0);
                minIdx = i;
            }
        }
        int maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.size(); i++) {
            if (i == minIdx)
                continue;
            maxDist = Math.max(maxDist, arrays.get(i).get(arrays.get(i).size() - 1) - min);
        }
        return maxDist;
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int maxtomin = maxToMin(arrays);
        int mintomax = minToMax(arrays);
        return maxtomin > mintomax ? maxtomin : mintomax;
    }
}