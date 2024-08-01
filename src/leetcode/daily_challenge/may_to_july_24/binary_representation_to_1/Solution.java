package leetcode.daily_challenge.may_to_july_24.binary_representation_to_1;

public class Solution {
    private String plusOne(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length() - 1;
        char carryIn = '1';
        for (; i >= 0; i--) {
            char currentBit = s.charAt(i);
            char sum = '0';
            char carryOut = '0';
            if (currentBit == '1' && carryIn == '1') {
                sum = '0';
                carryOut = '1';
            } else if ((currentBit == '1' && carryIn == '0') || (currentBit == '0' && carryIn == '1')) {
                sum = '1';
                carryOut = '0';
            } else {
                sum = '0';
                carryOut = '0';
            }
            stringBuilder.append(sum);
            carryIn = carryOut;
        }
        if (carryIn == '1') {
            stringBuilder.append(carryIn);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public int numSteps(String s) {
        int stepCount = 0;
        while (!"1".equals(s)) {
            if (s.charAt(s.length() - 1) == '1') {
                s = plusOne(s);
            } else {
                s = s.substring(0, s.length() - 1);
            }
            stepCount++;
        }
        return stepCount;
    }
}

// 1101 -> 13

// 1110 -> 14
// 111 -> 7
// 1000 -> 8
// 100-> 4
// 10 -> 2
// 1-> 1
