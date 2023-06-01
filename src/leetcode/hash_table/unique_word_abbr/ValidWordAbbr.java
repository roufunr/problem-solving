package leetcode.hash_table.unique_word_abbr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {
    //https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1137/
    private Map<String, Set<String>> table;

    public ValidWordAbbr(String[] dictionary) {
        table = new HashMap();
        for(String word : dictionary) {
           String abbr = getAbbrWordFromWord(word);
           if(table.containsKey(abbr)) {
               table.get(abbr).add(word);
           } else {
               Set<String> set = new HashSet<>();
               set.add(word);
               table.put(abbr, set);
           }
        }
    }

    public String getAbbrWordFromWord(String word) {
        if(word.length() <= 2) {
            return word;
        } else {
            char[] abbrWord = new char[3];
            abbrWord[0] = word.charAt(0);
            abbrWord[1] = (char)((word.length() - 2) + '0');
            abbrWord[2] = word.charAt(word.length() - 1);
            String newStr = new String(abbrWord);
            return newStr;
        }
    }

    public boolean isUnique(String word) {
        String abbrWord = getAbbrWordFromWord(word);
        boolean isPresent = table.containsKey(abbrWord);
        if(!isPresent) {
            return true;
        } else if(isPresent
                && table.get(abbrWord).contains(word)
                && table.get(abbrWord).size() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
