package leetcode.two_thousand_23.hash_table.happy_number;
import java.util.*;
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> appeared = new HashSet<>();
        while(true) {
            if(appeared.contains(n)) {
                return false;
            }
            appeared.add(n);
            if(n == 1) {
                return true;
            } else {
                String str = "" + n;
                char[] digits = str.toCharArray();
                int newN = 0;
                for(char digit : digits) {
                    int dgt = digit - '0';
                    newN += dgt * dgt;
                }
                n = newN;
            }
        }
    }
}
