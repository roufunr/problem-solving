package leetcode.daily_challenge.february_25.letter_tiles_possibilities_17;

import java.util.*;

public class Solution {
    private Set<String> combinations;
    private void backtrack(String tiles, boolean[] used, String sequence) {
        combinations.add(sequence);
        for(int i = 0; i < tiles.length();i++) {
            if(used[i] == false) {
                used[i] = true;
                backtrack(tiles, used, sequence + tiles.charAt(i));
                used[i] = false;
            }
        }
    }
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        String sequence = "";
        combinations = new HashSet<>();
        backtrack(tiles, used, sequence);
        return combinations.size() - 1;
    }
}