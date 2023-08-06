package leetcode.two_thousand_23.hash_table.isomorphic_string;

import java.util.*;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapF = new HashMap<>();
        Map<Character, Character> mapR = new HashMap<>();
        if(s.length() != t.length()) {
            return false;
        }
        for(int i = 0; i < t.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(mapF.containsKey(cs) && mapR.containsKey(ct)) {
                if(mapF.get(cs) == ct && mapR.get(ct) == cs) {
                    continue;
                } else {
                    return false;
                }
            } else if (mapF.containsKey(cs) || mapR.containsKey(ct)) {
                return  false;
            } else if (!mapF.containsKey(cs) && !mapR.containsKey(ct)) {
                mapF.put(cs, ct);
                mapR.put(ct, cs);
            } else {
                return false;
            }
        }
        return true;
    }
}
