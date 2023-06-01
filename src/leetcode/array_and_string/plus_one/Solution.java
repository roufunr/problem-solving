package leetcode.array_and_string.plus_one;

public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
    public int[] plusOne(int[] digits) {
        int numberOfDigits = digits.length;
        int[] newDigitArr = new int[numberOfDigits+1];
        int carryIn = 1;
        for(int i = newDigitArr.length -1; i > 0; i--) {
            int sum = digits[i - 1] + carryIn;
            newDigitArr[i] = sum % 10;
            carryIn = sum / 10;
        }
        newDigitArr[0] = carryIn;
        if(carryIn == 0) {
            int[] digitSeq = new int[digits.length];
            for(int i = 0; i < newDigitArr.length - 1; i++) {
                digitSeq[i] = newDigitArr[i + 1];
            }
            newDigitArr = digitSeq;
        }

        return newDigitArr;
    }
}
