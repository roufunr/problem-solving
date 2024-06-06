package leetcode.daily_challenge.group_of_hands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
			return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        int i = 0;
        while(i < keys.length - groupSize + 1) {
            int cursor = i;
            for(int j = cursor; j < cursor + groupSize; j++) {
                if(j == cursor) {
                    map.put(keys[j], map.get(keys[j]) - 1);
                } else {
                    if(keys[j] - keys[j - 1] > 1) {
                        return false;
                    } else {
                        map.put(keys[j], map.get(keys[j]) - 1);
                    }
                }
                if(map.get(keys[j]) == 0) {
                    i++;
                }
            }
        }
        
        for(Integer key : keys) {
            if(map.get(key) > 0) {
                return false;
            }
        }
        return true;
    }
}

