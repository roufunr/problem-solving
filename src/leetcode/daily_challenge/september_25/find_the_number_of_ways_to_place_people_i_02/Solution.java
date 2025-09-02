package leetcode.daily_challenge.september_25.find_the_number_of_ways_to_place_people_i_02;

public class Solution {
    public int numberOfPairs(int[][] points) {
        int ans = 0;
        for(int i = 0; i < points.length; i++) {
            int[] rb = points[i];
            for(int j = 0; j < points.length; j++) {
                if(j == i) {
                    continue;
                }
                int[] tl = points[j];
                if(tl[0] <= rb[0] && tl[1] >= rb[1]) {
                    boolean found = false;
                    for(int k = 0; k < points.length; k++) {
                        if(k == i || k == j) {
                            continue;
                        }
                        int[] check = points[k];
                        if(check[0] <= rb[0] && check[0] >= tl[0] && check[1] <= tl[1] && check[1] >= rb[1]) {
                            found = true;
                            break;
                        }
                    }
                    ans += found ? 0 : 1;
                }
            }
        }
        return ans;
    }
}