package leetcode.two_thousand_24.weekly_contest.maximum_points_after_enemy_battles;

import java.util.Arrays;

public class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        int i = 0;
        int j = enemyEnergies.length - 1;
        if (currentEnergy < enemyEnergies[0]) {
            return 0;
        }
        long point = 0;
        while (j >= 0) {
            if (enemyEnergies[0] <= currentEnergy) {
                point += currentEnergy / enemyEnergies[0];
                currentEnergy = currentEnergy % enemyEnergies[0];
            } else {
                currentEnergy += enemyEnergies[j];
                j--;
            }
        }
        return point;
    }
}
