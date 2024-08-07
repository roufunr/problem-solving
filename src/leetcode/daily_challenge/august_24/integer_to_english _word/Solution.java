package leetcode.daily_challenge.august_24.integer_to_english_word;

import java.util.*;

public class Solution {
    private Map<Integer, String> map = new HashMap<>();

    public Solution() {
        map.put(0, "");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
        // map.put(1000000000000, "Trillion");
    }

    private String trimmer(String str) {
        return str.trim();
    }

    private String uptoTwoDigitString(int num) {
        if (num / 10 == 0 || num % 10 == 0) {
            return map.get(num);
        } else if (num >= 10 && num <= 20) {
            return map.get(num);
        } else {
            int tenth = (num / 10) * 10;
            int oneth = num % 10;
            return trimmer(map.get(tenth) + " " + map.get(oneth));
        }
    }

    private String uptoThreeDigitString(int num) {
        if (num / 100 == 0) {
            return uptoTwoDigitString(num);
        } else {
            int hundredth = num / 100;
            return trimmer(map.get(hundredth) + " " + map.get(100) + " " + uptoTwoDigitString(num % 100));
        }
    }

    private String uptoSixDigitString(int num) {
        if (num / 1000 == 0) {
            return uptoThreeDigitString(num);
        } else {
            int thousandth = num / 1000;
            return trimmer(
                    uptoThreeDigitString(thousandth) + " " + map.get(1000) + " " + uptoThreeDigitString(num % 1000));
        }
    }

    private String uptoNineDigitString(int num) {
        if (num / 1000000 == 0) {
            return uptoSixDigitString(num);
        } else {
            int millionth = num / 1000000;
            return trimmer(
                    uptoThreeDigitString(millionth) + " " + map.get(1000000) + " " + uptoSixDigitString(num % 1000000));
        }
    }

    private String convert(int num) {
        if (num / 1000000000 == 0) {
            return uptoNineDigitString(num);
        } else {
            int billionth = num / 1000000000;
            return trimmer(uptoThreeDigitString(billionth) + " " + map.get(1000000000) + " "
                    + uptoNineDigitString(num % 1000000000));
        }
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return convert(num);
    }
}