package leetcode.hash_table.group_shifted_str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public String getHashString(String str) {
        char[] chars = str.toCharArray();
        int distanceFromA = chars[0] - 'a';
        for(int i = 0; i < chars.length; i++) {
            chars[i] = (char)(((chars[i] - 'a') - distanceFromA + 26) % 26 + 'a');
        }
        return String.valueOf(chars);
    }

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strings) {
            String hashStr = getHashString(str);
            if(map.containsKey(hashStr)) {
                map.get(hashStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(hashStr, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        map.forEach((k,v) -> ans.add(v));
        return ans;
    }
}
