package leetcode.daily_challenge.september_25.find_closest_person_04;

public class Solution {
    public int findClosest(int x, int y, int z) {
        return Math.abs(z-x) == Math.abs(z-y) ? 0 : (Math.abs(z-x) < Math.abs(z-y) ? 1 : 2);
    }
}