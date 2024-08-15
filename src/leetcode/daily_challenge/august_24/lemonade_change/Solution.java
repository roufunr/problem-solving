package leetcode.daily_challenge.august_24.lemonade_change;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> notesCount = new HashMap<>();
        notesCount.put(5, 0);
        notesCount.put(10, 0);
        notesCount.put(20, 0);
        for(int i = 0; i < bills.length; i++) {
            notesCount.put(bills[i], notesCount.get(bills[i]) + 1);
            int change = bills[i] - 5;
            if(change == 15) {
                if(notesCount.get(10) >= 1 && notesCount.get(5) >= 1) {
                    notesCount.put(5, notesCount.get(5) - 1);
                    notesCount.put(10, notesCount.get(10) - 1);
                } else if(notesCount.get(5) >= 3) {
                    notesCount.put(5, notesCount.get(5) - 3);
                } else {
                    return false;
                }
            } else if(change == 5) {
                if(notesCount.get(5) > 0 ) {
                    notesCount.put(5, notesCount.get(5) - 1);
                } else {
                    return false;
                }
            } else {
                // no nothing
            }
        }
        return true;
    }
}

