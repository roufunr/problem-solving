package leetcode.daily_challenge.august_24.min_number_of_pushes_to_type_word_II;

import java.util.*;

class Pair {
    char c;
    int count;

    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}

public class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        List<Pair> countList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0)
                countList.add(new Pair((char) (i + 'a'), count[i]));
        }
        Comparator<Pair> comparator = new Comparator<>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p2.count, p1.count);
            }
        };
        Collections.sort(countList, comparator);
        int ans = 0;
        for (int i = 0; i < countList.size(); i++) {
            ans += (i / 8 + 1) * countList.get(i).count;
        }
        return ans;
    }
}