package leetcode.daily_challenge.august_25.reordered_power_of_2_10;
import java.util.*;
public class Solution {
    public boolean reorderedPowerOf2(int n) {
        Map<Integer, List<Map<Character, Integer>>> map = new HashMap<>();
        for(int i = 0; i < 32; i++) {
            String number = "" + (int) Math.pow(2, i);
            int len = number.length();
            Map<Character, Integer> digitCountMap = new HashMap<>();
            for(int j = 0; j < len; j++) {
                char digit = number.charAt(j);
                digitCountMap.put(digit, digitCountMap.getOrDefault(digit, 0) + 1);
            }
            if(!map.containsKey(len)) {
                map.put(len, new ArrayList<>());
            }
            map.get(len).add(digitCountMap);
        }
        String givenNumber = "" + n;
        int len = givenNumber.length();
        Map<Character, Integer> digitCountMap = new HashMap<>();
        for(int j = 0; j < len; j++) {
            char digit = givenNumber.charAt(j);
            digitCountMap.put(digit, digitCountMap.getOrDefault(digit, 0) + 1);
        }
        
        
        
        List<Map<Character, Integer>> listofMaps = map.get(len);
        
        for(Map<Character, Integer> powerNumber : listofMaps) {
            boolean found = true;
            for(Character key : powerNumber.keySet()) {
                if(!digitCountMap.containsKey(key)) {
                    found = false;
                    break;
                } else {
                    if(digitCountMap.get(key) != powerNumber.get(key)) {
                        found = false;
                        break;
                    }
                }
            }
            if(found) {
                return true;
            }
        }

        return false;
    }
}