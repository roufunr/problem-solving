package leetcode.daily_challenge.august_24.min_number_of_pushes_to_type_word_II;

import java.util.*;

public class SolutionII {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0)
                countList.add(count[i]);
        }
        Collections.sort(countList, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < countList.size(); i++) {
            ans += (i / 8 + 1) * countList.get(i);
        }
        return ans;
    }
}