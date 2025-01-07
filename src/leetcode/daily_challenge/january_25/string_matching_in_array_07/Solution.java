package leetcode.daily_challenge.january_25.string_matching_in_array_07;
import java.util.*;
public class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> ans = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                String str1 = words[i];
                String str2 = words[j];
                String supStr = str1.length() >= str2.length() ? str1 : str2;
                String subStr = str1.length() < str2.length() ? str1 : str2;
                for(int k = 0; k < supStr.length(); k++) {
                    if(supStr.substring(k).startsWith(subStr)) {
                        ans.add(subStr);
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}