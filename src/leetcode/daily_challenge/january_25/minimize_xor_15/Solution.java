package leetcode.daily_challenge.january_25.minimize_xor_15;

import java.util.*;

public class Solution {
    public int minimizeXor(int num1, int num2) {
        int count2 = 0;
        while (num2 > 0) {
            count2 += (num2 % 2);
            num2 /= 2;
        }
        List<Boolean> num1Bool = new ArrayList<>();
        int count1 = 0;
        int num1Copy = num1;
        while (num1Copy > 0) {
            num1Bool.add((num1Copy % 2) == 1);
            if ((num1Copy % 2) == 1) {
                count1++;
            }
            num1Copy /= 2;
        }
        if (count1 == count2) {
            return num1;
        }
        Collections.reverse(num1Bool);
        if (count2 > count1) {
            int x = num1;
            int temp = x;
            int j = 0;
            int rem = count2 - count1;
            int totalBits = 0;
            while (temp > 0 && rem > 0) {
                if (temp % 2 == 0) {
                    x += Math.pow(2, j);
                    rem--;
                }
                totalBits++;
                temp /= 2;
                j++;
            }
            if (rem > 0) {
                for (int i = 0; i < rem; i++) {
                    x += Math.pow(2, totalBits);
                    totalBits++;
                }
            }
            return x;
        }
        int x = 0;
        for (int i = 0; i < num1Bool.size(); i++) {
            if (num1Bool.get(i)) {
                x += Math.pow(2, num1Bool.size() - i - 1);
                count2--;
            }
            if (count2 == 0) {
                break;
            }
        }
        return x;
    }
}