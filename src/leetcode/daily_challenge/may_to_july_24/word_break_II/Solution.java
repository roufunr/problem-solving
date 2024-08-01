package leetcode.daily_challenge.may_to_july_24.word_break_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> lineage;
    public List<String> result;

    private void generateAllSentences(String s, Set<String> hashset) {
        if (s.length() == 0 || s.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < lineage.size() - 1; i++) {
                stringBuilder.append(lineage.get(i)).append(" ");
            }
            stringBuilder.append(lineage.get(lineage.size() - 1));
            result.add(stringBuilder.toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            if (hashset.contains(stringBuilder.toString())) {
                lineage.add(stringBuilder.toString());
                generateAllSentences(s.substring(i + 1, s.length()), hashset);
                lineage.remove(lineage.size() - 1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> hashset = new HashSet<>();
        lineage = new ArrayList<>();
        result = new ArrayList<>();
        for (String word : wordDict) {
            hashset.add(word);
        }
        generateAllSentences(s, hashset);
        return result;
    }
}