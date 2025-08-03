package leetcode.daily_challenge.august_25.rearranging_fruits_02;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    // Given two baskets of fruits, we want to rearrange them such that each basket has the same number of each type of fruit.
    // We can swap fruits between the baskets, and we want to minimize the cost of these swaps.
    // The cost of swapping a fruit is defined as the minimum of the fruit's value and twice the minimum value of any fruit in either basket.
    // If it's impossible to rearrange the baskets, we return -1.
    // The function minCost takes two integer arrays representing the two baskets and returns the minimum cost of rearranging them.
    // If it's impossible to rearrange, it returns -1.
    // Time complexity: O(n log n) due to TreeMap operations and space complexity: O(n) for storing the counts of fruits.
    // Note: The input arrays are guaranteed to have the same length.
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int globalMin = Integer.MAX_VALUE;
        for(int item : basket1) {
            map.put(item, map.getOrDefault(item, 0) + 1);
            globalMin = Math.min(item, globalMin);
        }
        for(int item : basket2) {
            map.put(item, map.getOrDefault(item, 0) - 1);
            globalMin = Math.min(item, globalMin);
        }
        List<Integer> swapItems = new ArrayList<>();
        for(Integer item : map.keySet()) {
            int count = Math.abs(map.get(item)); 
            // Math abs is important because the count could be negative
            System.out.println(count + " < " + item);
            if(count % 2 == 1) { 
                // impossible case
                return -1;
            }
            for(int i = 0; i < (count / 2); i++) {
                swapItems.add(item);
            }
        }
        System.out.println(swapItems);
        long totalCost = 0;
        for(int i = 0; i < swapItems.size() / 2; i++) {
            totalCost += Math.min(swapItems.get(i), globalMin * 2);
        }
        return totalCost;
    }
}
