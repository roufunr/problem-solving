package leetcode.daily_challenge.october_24.rank_transform_of_an_array;

import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sortedArr[i])) {
                continue;
            }
            map.put(sortedArr[i], cnt++);
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]) + 1;
        }
        return ans;
    }
}