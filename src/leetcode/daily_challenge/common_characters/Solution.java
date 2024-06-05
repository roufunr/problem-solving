package leetcode.daily_challenge.common_characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> commonChars(String[] words) {
        List<Map<Character, Integer>> wordMap = new ArrayList<>();
        for(String word : words) {
            Map<Character, Integer> map = new HashMap<>();
            for(char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            wordMap.add(map);
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            int presentInAllWord = Integer.MAX_VALUE;
            for(int j = 0; j < words.length; j++) {
                if(!wordMap.get(j).containsKey(c)) {
                    presentInAllWord = 0;
                    break;
                } else {
                    presentInAllWord = Math.min(presentInAllWord, wordMap.get(j).get(c));
                    wordMap.get(j).remove(c);
                }
            }
            if(presentInAllWord < Integer.MAX_VALUE && presentInAllWord > 0) {
                for(int k = 0; k < presentInAllWord; k++) {
                    ans.add("" + c);
                }
            }
        }
        return ans;
    }
}