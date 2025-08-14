package leetcode.daily_challenge.august_25.largest_3_same_digit_number_in_string_15;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String largestGoodInteger(String num) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= 9; i++) {
            String str = i + "" + i + "" + i;
            map.put(str, i);
        }
        
        String ans = "";
        int max = -1;
        for(int i = 0; i < num.length() - 2; i++) {
            String substr = num.substring(i, i + 3);
            // System.out.println(substr);
            if(map.containsKey(substr)) {
                if(max < map.get(substr)) {
                    max = map.get(substr);
                    ans = substr;
                }
            }
        }
        return ans;
    }
}