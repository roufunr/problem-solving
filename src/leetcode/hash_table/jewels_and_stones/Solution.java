package leetcode.hash_table.jewels_and_stones;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1136/
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        char[] jewelsCharArray = jewels.toCharArray();
        for(char c : jewelsCharArray) {
            jewelsSet.add(c);
        }

        char[] stonesCharArray = stones.toCharArray();
        int counter = 0;
        for(char c : stonesCharArray) {
            if(jewelsSet.contains(c)) {
                counter++;
            }
        }
        return counter;
    }
}
