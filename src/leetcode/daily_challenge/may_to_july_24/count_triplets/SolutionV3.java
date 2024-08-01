package leetcode.daily_challenge.may_to_july_24.count_triplets;

import java.util.HashMap;
import java.util.Map;

class Pair {
    public int count;
    public int idxSum;

    public Pair(int count, int idxSum) {
        this.count = count;
        this.idxSum = idxSum;
    }
}

public class SolutionV3 {
    public int countTriplet(int[] arr) {
        int result = 0;
        int currentXOR = 0;
        Map<Integer, Pair> map = new HashMap<>();
        map.put(0, new Pair(1, 0));
        for (int k = 0; k < arr.length; k++) {
            currentXOR ^= arr[k];
            if (map.containsKey(currentXOR)) {
                Pair pair = map.get(currentXOR);
                result += (k * pair.count) - pair.idxSum;
            }
            if (!map.containsKey(currentXOR)) {
                Pair pair = new Pair(1, k + 1);
                map.put(currentXOR, pair);
            } else {
                Pair pair = map.get(currentXOR);
                pair.count += 1;
                pair.idxSum += (k + 1);
            }
        }
        return result;
    }
}
