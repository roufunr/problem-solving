package leetcode.daily_challenge.january_25.minimum_number_of_operations_to_move_all_balls_to_each_box_06;
import java.util.*;
public class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> positions = new ArrayList<>();
        for(int i = 0; i < boxes.length(); i++) {
            if(boxes.charAt(i) == '1') {
                positions.add(i);
            }
        }
        int[] ans = new int[boxes.length()];
        for(int i = 0; i < boxes.length(); i++) {
            int sum = 0;
            for(int pos : positions) {
                sum += Math.abs(pos - i);
            }
            ans[i] = sum;
        }
        return ans;
    }
}