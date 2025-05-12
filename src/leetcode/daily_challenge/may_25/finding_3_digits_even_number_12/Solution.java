package leetcode.daily_challenge.may_25.finding_3_digits_even_number_12;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for(int digit : digits) {
            count[digit]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 100; i < 1000; i+=2) {
            int[] tempCount = new int[10];
            int x = i;
            while(x > 0) {
                tempCount[x % 10]++;
                x = x / 10;
            }
            boolean isPossible = true;
            for(int j = 0; j < 10; j++) {
                if(tempCount[j] > count[j]) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                ans.add(i);
            }
        }
        int[] ansArray = new int[ans.size()];
        for(int i = 0; i < ansArray.length; i++) {
            ansArray[i] = ans.get(i);
        } 
        return ansArray;
    }
}