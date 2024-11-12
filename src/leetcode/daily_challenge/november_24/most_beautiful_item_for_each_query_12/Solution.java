package leetcode.daily_challenge.november_24.most_beautiful_item_for_each_query_12;

import java.util.*;

class Pair {
    public int price;
    public int beauty;

    public Pair(int price, int beauty) {
        this.price = price;
        this.beauty = beauty;
    }
}

public class Solution {
    private int binary_search(List<Pair> itemPairs, int query) {
        int left = 0;
        int right = itemPairs.size() - 1;
        int resultIdx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (itemPairs.get(mid).price <= query) {
                resultIdx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (resultIdx == -1) {
            return 0;
        } else {
            return itemPairs.get(resultIdx).beauty;
        }
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        List<Pair> itemPairs = new ArrayList<>();
        for (int[] item : items) {
            itemPairs.add(new Pair(item[0], item[1]));
        }
        Collections.sort(itemPairs, (a, b) -> (a.price - b.price));
        int max = itemPairs.get(0).beauty;
        for (int i = 0; i < itemPairs.size(); i++) {
            max = Math.max(max, itemPairs.get(i).beauty);
            itemPairs.get(i).beauty = max;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = binary_search(itemPairs, queries[i]);
        }
        return ans;
    }
}
