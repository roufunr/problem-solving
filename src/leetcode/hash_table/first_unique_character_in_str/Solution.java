package leetcode.hash_table.first_unique_character_in_str;

import java.util.HashMap;

public class Solution {
    public int firstUniqChar(String s) {
        //https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1120/
        HashMap<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        for(char c : sArr) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }


        for(int i = 0; i < sArr.length; i++) {
            if(map.get(sArr[i]) == 1) {
                return i;
            } else {
                continue;
            }
        }
        return  -1;
    }
}
