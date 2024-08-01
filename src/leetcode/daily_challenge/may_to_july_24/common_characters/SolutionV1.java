package leetcode.daily_challenge.may_to_july_24.common_characters;

import java.util.*;

public class SolutionV1 {
    Map<Character, Integer> getTheCountMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public List<String> commonChars(String[] words) {
        Map<Character, Integer> fMap = getTheCountMap(words[0]);
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> cMap = getTheCountMap(words[i]);
            Character[] keys = fMap.keySet().toArray(new Character[0]);
            for (int j = 0; j < keys.length; j++) {
                fMap.put(keys[j], Math.min(fMap.get(keys[j]), cMap.getOrDefault(keys[j], 0)));
                // System.out.println(keys[i]);
                // System.out.println(Math.min(fMap.get(keys[i]), cMap.getOrDefault(keys[i],
                // 0)));
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (fMap.containsKey(c)) {
                int cCount = fMap.get(c);
                if (cCount > 0) {
                    for (int k = 0; k < cCount; k++) {
                        ans.add(c + "");
                    }
                }
            }
        }
        return ans;
    }
}