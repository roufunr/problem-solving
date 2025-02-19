package leetcode.daily_challenge.february_25.the_k_th_lexicographical_string_of_all_happy_string_of_length_n_19;

import java.util.*;
public class Solution {

    List<String> happyStrings = new ArrayList<>();

    public String getHappyString(int n, int k) {
        String currentString = "";
        generateHappyStrings(n, currentString);
        if (happyStrings.size() < k) return "";
        Collections.sort(happyStrings);
        return happyStrings.get(k - 1);
    }

    protected void generateHappyStrings(int n, String currentString) {
        if (currentString.length() == n) {
            happyStrings.add(currentString);
            return;
        }
        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            if (currentString.length() > 0 && currentString.charAt(currentString.length() - 1) == currentChar)
                continue;
            generateHappyStrings(n, currentString + currentChar);
        }
    }
}
