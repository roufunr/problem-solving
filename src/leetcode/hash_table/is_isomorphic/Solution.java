package leetcode.hash_table.is_isomorphic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s_to_t = new HashMap<>();
        HashMap<Character, Character> t_to_s = new HashMap<>();
        if(s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        for(int i = 0; i < len; i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            if(
                    s_to_t.containsKey(sc) &&
                    t_to_s.containsKey(tc) &&
                    s_to_t.get(sc) == tc &&
                    t_to_s.get(tc) == sc
            ) {
                continue;
            } else if(!s_to_t.containsKey(sc) && !t_to_s.containsKey(tc)) {
                s_to_t.put(sc, tc);
                t_to_s.put(tc, sc);
            } else {
                return false;
            }
        }
        return true;
    }
}
