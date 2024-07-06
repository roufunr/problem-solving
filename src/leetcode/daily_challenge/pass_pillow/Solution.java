package leetcode.daily_challenge.pass_pillow;

public class Solution {
    public int passThePillow(int n, int time) {
        if (n - 1 >= time) {
            return time + 1;
        }
        int q = time / (n - 1);
        int r = time % (n - 1);
        return q % 2 == 0 ? r + 1 : (n - r);
    }
}
