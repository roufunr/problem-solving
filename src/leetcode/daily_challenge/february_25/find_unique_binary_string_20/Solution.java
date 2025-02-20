package leetcode.daily_challenge.february_25.find_unique_binary_string_20;

import java.util.*;
public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        for(String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }
        StringBuilder ansNum = new StringBuilder();
        for(int i = 0; i < Math.pow(2, nums.length); i++) {
            if(!set.contains(i)) {
                ansNum.append(Integer.toBinaryString(i));
                break;
            }
        }
        StringBuilder pad = new StringBuilder();
        while(ansNum.length() + pad.length() < nums.length) {
            pad.append('0');
        }
        return pad.append(ansNum).toString();
    }
}