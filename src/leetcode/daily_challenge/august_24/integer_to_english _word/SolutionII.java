package leetcode.daily_challenge.august_24.integer_to_english_word;

import java.util.*;

public class SolutionII {
    private Map<Integer, String> map = new HashMap<>();

    public SolutionII() {
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

    private String converter(int num) {
        if (num < 100) {
            if (num / 10 == 0 || num % 10 == 0) {
                return map.get(num);
            } else if (num >= 10 && num <= 20) {
                return map.get(num);
            } else {
                int tenth = (num / 10) * 10;
                int oneth = num % 10;
                return trimmer(map.get(tenth) + " " + map.get(oneth));
            }
        } else if (num >= 100 && num < 1000) {
            int nth = num / 100;
            return trimmer(map.get(nth) + " " + map.get(100) + " " + converter(num % 100));
        } else if (num >= 1000 && num < 1000 * 1000) {
            int nth = num / 1000;
            return trimmer(converter(nth) + " " + map.get(1000) + " " + converter(num % 1000));
        } else if (num >= 1000 * 1000 && num < 1000 * 1000 * 1000) {
            int nth = num / (1000 * 1000);
            return trimmer(converter(nth) + " " + map.get(1000 * 1000) + " " + converter(num % (1000 * 1000)));
        } else {
            int nth = num / (1000 * 1000 * 1000);
            return trimmer(
                    converter(nth) + " " + map.get(1000 * 1000 * 1000) + " " + converter(num % (1000 * 1000 * 1000)));
        }
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return converter(num);
    }
}