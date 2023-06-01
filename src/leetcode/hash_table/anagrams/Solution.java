package leetcode.hash_table.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> anagramsMap = new HashMap<>();
        for(String str : strs) {
            int len = str.length();
            HashMap<Character, Integer> eachWordMap = new HashMap<>();
            for(int i = 0; i < len; i++) {
                char c = str.charAt(i);
                if(eachWordMap.containsKey(c)) {
                    eachWordMap.put(c, eachWordMap.get(c) + 1);
                } else {
                    eachWordMap.put(c, 1);
                }
            }
            if(anagramsMap.containsKey(eachWordMap)) {
                anagramsMap.get(eachWordMap).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                anagramsMap.put(eachWordMap, list);
            }
        }

        List<List<String>> anagramsList = new ArrayList<>();
        for(Map.Entry<HashMap<Character, Integer>, List<String>> entry :  anagramsMap.entrySet()) {
            anagramsList.add(entry.getValue());
        }
        return anagramsList;
    }
}
