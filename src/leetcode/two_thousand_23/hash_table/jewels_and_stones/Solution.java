package leetcode.two_thousand_23.hash_table.jewels_and_stones;
import java.util.*;

public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int numberOfJewelsInStone = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char jewel : jewels.toCharArray()) {
            map.put(jewel, 0);
        }
        for(char stone : stones.toCharArray()) {
            if(map.containsKey(stone)) {
                map.put(stone, map.get(stone) + 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            numberOfJewelsInStone += entry.getValue();
        }
        return numberOfJewelsInStone;
    }
}

