package leetcode.daily_challenge.august_25.fruits_into_baskets_ii_05;
public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        for(int i = 0; i < fruits.length; i++) {
            for(int k = 0; k < baskets.length; k++) {
                if(baskets[k] >= fruits[i]) {
                    baskets[k] = -baskets[k];
                    break;
                }

            }
        }
        int count = 0;
        for(int basket : baskets) {
            if(basket > 0) {
                count++;
            }
        }
        return count;
    }
}
