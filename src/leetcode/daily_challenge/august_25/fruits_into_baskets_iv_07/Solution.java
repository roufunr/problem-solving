package leetcode.daily_challenge.august_25.fruits_into_baskets_iv_07;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private int calculateDp(int[][] fruits) {
        Map<String, Integer> dp = new HashMap<>();
        int peak = fruits.length / 2;
        
        for(int i = 0; i < peak; i++) {
            for(int j = i; j >= 0; j--) {
                int x = i;
                int y = fruits.length - j - 1;

                int prevLeft = dp.containsKey((x - 1) + "_" + (y - 1)) == false ? 0 : dp.get((x - 1) + "_" + (y - 1));
                int prev = dp.containsKey((x - 1) + "_" + (y)) == false ? 0 : dp.get((x - 1) + "_" + (y));
                int prevRight = dp.containsKey((x - 1) + "_" + (y + 1)) == false ? 0 : dp.get((x - 1) + "_" + (y + 1));

                dp.put(x + "_" + y, Math.max(prevLeft, Math.max(prev, prevRight)) + fruits[x][y]);
            }
        }

        int k = peak;
        for(int i = (fruits.length % 2 == 0) ? peak - 1 : peak; i >= 1; i--) {
            for(int j = i; j >= 1; j--) {
                int x = k;
                int y = fruits.length - j;

                int prevLeft = dp.containsKey((x - 1) + "_" + (y - 1)) == false ? 0 : dp.get((x - 1) + "_" + (y - 1));
                int prev = dp.containsKey((x - 1) + "_" + (y)) == false ? 0 : dp.get((x - 1) + "_" + (y));
                int prevRight = dp.containsKey((x - 1) + "_" + (y + 1)) == false ? 0 : dp.get((x - 1) + "_" + (y + 1));


                dp.put(x + "_" + y, Math.max(prevLeft, Math.max(prev, prevRight)) + fruits[x][y]);
            }
            k++;
        }
        return dp.get((fruits.length - 2) + "_" + (fruits.length - 1));
    }

    private void transpose(int[][] fruits) {
        for(int i = 1; i < fruits.length; i++) {
            for(int j = 0; j < i; j++) {
                int temp = fruits[j][i];
                fruits[j][i] = fruits[i][j];
                fruits[i][j] = temp;
            }
        }
    }

    private int getDiagonalSum(int[][] fruits) {
        int maxFruits = 0;
        for(int i = 0; i < fruits.length; i++) { // diagonal
            maxFruits += fruits[i][i];
        }
        return maxFruits;
    }

    public int maxCollectedFruits(int[][] fruits) {
        int maxFruits = getDiagonalSum(fruits);
        maxFruits += calculateDp(fruits);
        transpose(fruits);
        maxFruits += calculateDp(fruits);
        return maxFruits;
    }
}