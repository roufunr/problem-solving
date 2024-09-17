package leetcode.daily_challenge.september_24.uncommon_words_from_two_sentences_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : s1.split(" ")) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        for (String word : s2.split(" ")) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String key : words.keySet()) {
            if (words.get(key) == 1) {
                ans.add(key);
            }
        }
        return ans.toArray(new String[0]);
    }
}
