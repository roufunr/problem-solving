package leetcode.daily_challenge.august_25.fruits_into_baskets_iii_06;

import java.util.Arrays;

public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int sectionSize = (int) Math.sqrt(baskets.length);
        int totalSection = (baskets.length + sectionSize - 1) / sectionSize; // this is the waty to get the ceil
        int[] maxValues = new int[totalSection];
        Arrays.fill(maxValues, 0);
        for(int i = 0; i < fruits.length; i++) {
            maxValues[i / sectionSize] = Math.max(maxValues[i / sectionSize], baskets[i]);
        }

        int count = 0;
        for(int fruit : fruits) {
            int k = 0;
            while(k < totalSection && fruit > maxValues[k]) {
                k++;
            }
            if(k == totalSection) {
                count++;
                continue;
            }
            maxValues[k] = 0;
            boolean taken = false;
            for(int m = 0; m < sectionSize && k * sectionSize + m < baskets.length; m++) {
                int basket = baskets[k * sectionSize + m];
                if(basket >= fruit && taken == false) {
                    baskets[k * sectionSize + m] = 0;
                    taken = true;
                }
                maxValues[k] = Math.max(baskets[k * sectionSize + m], maxValues[k]);
            }
        }
        return count;
    }
}