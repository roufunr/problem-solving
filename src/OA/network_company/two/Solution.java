package OA.network_company.two;
import java.util.*;
public class Solution {
    public void  funcUpdation(String currPassword, String newPassword)
	{
		Map<Character, Integer> currMap = new HashMap<>();
		for(char c : currPassword.toCharArray()) {
            currMap.put(c, currMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> newMap = new HashMap<>();
		for(char c : newPassword.toCharArray()) {
            newMap.put(c, newMap.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for(Character key : newMap.keySet()) {
            if(!currMap.containsKey(key)) {
                // insertion count
                count += newMap.get(key);
            }
        }

        for(Character key : currMap.keySet()) {
            if(!newMap.containsKey(key)) {
                // deletion count
                count += currMap.get(key);
            }
        }

        System.out.println(count);
		
	}
}
