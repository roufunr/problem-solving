package leetcode.current.beginners_guide.ransom_note;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // https://leetcode.com/problems/ransom-note/
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteArray = ransomNote.toCharArray();
        char[] magazineArray = magazine.toCharArray();

        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();

        for(char c : ransomNoteArray) {
            if(ransomMap.containsKey(c)) {
                ransomMap.put(c, ransomMap.get(c) + 1);
            } else {
                ransomMap.put(c, 1);
            }
        }

        for(char c : magazineArray) {
            if(magazineMap.containsKey(c)) {
                magazineMap.put(c, magazineMap.get(c) + 1);
            } else {
                magazineMap.put(c, 1);
            }
        }

        for(char c : ransomNoteArray) {
            if(!magazineMap.containsKey(c)) {
                return false;
            } else if (magazineMap.get(c) >= ransomMap.get(c)) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }
}
