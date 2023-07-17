package leetcode.two_thousand_23.arrays_and_strings.plus_one;

public class Solution {
    // https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
    public int[] plusOne(int[] digits) {
        int remainder = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            int newDigits = (digits[i] + remainder + (i == digits.length - 1 ? 1 : 0)) % 10;
            remainder = (digits[i] + remainder + (i == digits.length - 1 ? 1 : 0)) / 10;
            digits[i] = newDigits;
        }
        if(remainder > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = remainder;
            for(int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            digits = newDigits;
        }
        return digits;
    }

}
