package lc_others.watering_plants;

public class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int totalSteps = 0;
        int currentCap = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (currentCap < plants[i]) {
                totalSteps += (2 * i) + 1;
                currentCap = capacity;
            } else {
                totalSteps += 1;
            }
            currentCap -= plants[i];
        }
        return totalSteps;
    }
}