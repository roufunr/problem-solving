package leetcode.two_thousand_23.hash_table.group_anagram;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Map<Character, Integer> charmap = new HashMap<>();
            for(int i = 0; i < 26; i++) {
                charmap.put((char)('a' + i), 0);
            }
            for(int i = 0; i < chars.length; i++) {
                charmap.put(chars[i], charmap.get(chars[i]) + 1);
            }
            StringBuffer keyBuffer = new StringBuffer();
            for(Map.Entry<Character, Integer> entry : charmap.entrySet()) {
                if(entry.getValue() > 0) {
                    keyBuffer.append("" + entry.getKey() + entry.getValue());
                }
            }
            String key = keyBuffer.toString();
            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }
}
