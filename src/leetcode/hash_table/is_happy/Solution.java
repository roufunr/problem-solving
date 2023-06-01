package leetcode.hash_table.is_happy;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1131/
    private int nextNumber(int n) {
        int nextNum = 0;
        while(n != 0) {
            int lastDigit = n % 10;
            n = n / 10;
            nextNum += lastDigit * lastDigit;
        }
        return nextNum;
    }
    public boolean isHappy(int n) {
        Set<Integer> alreadyExplored = new HashSet<>();
        alreadyExplored.add(n);
        while(n != 1) {
            int nextNum = nextNumber(n);
            //System.out.println(nextNum);
            if(alreadyExplored.contains(nextNum) && nextNum!=1) {
                return false;
            } else {
                alreadyExplored.add(nextNum);
            }
            n = nextNum;
        }
        return true;
    }
}
