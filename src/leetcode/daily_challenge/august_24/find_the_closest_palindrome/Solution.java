package leetcode.daily_challenge.august_24.find_the_closest_palindrome;

public class Solution {
    private long generatePalindromeFromHalf(long firstHalf, boolean odd) {
        long res = firstHalf;
        if(odd) {
            firstHalf /= 10;
        }
        while(firstHalf > 0) {
            res = res * 10 + (firstHalf % 10);
            firstHalf /= 10;
        }
        return res;
    }
    public String nearestPalindromic(String n) {
        long[] possibilities = new long[5];
        int len = n.length();
        long firstHalf = Long.parseLong(len % 2 == 0 ? n.substring(0, len/2) : n.substring(0, len/2 + 1));
        // Palindrome formed from the first half of n.
        possibilities[0] = generatePalindromeFromHalf(firstHalf, len % 2 == 1);
        // Palindrome formed from the first half decremented by 1.
        possibilities[1] = generatePalindromeFromHalf(firstHalf + 1, len % 2 == 1);
        // Palindrome formed from the first half incremented by 1.
        possibilities[2] = generatePalindromeFromHalf(firstHalf - 1, len % 2 == 1);
        // Nearest palindrome of the form 99, 999, etc.
        possibilities[3] = (long)(Math.pow(10, len - 1) - 1);
        // Nearest palindrome of the form 101, 1001, etc.
        possibilities[4] = (long)(Math.pow(10, len) + 1);
        // System.out.println(possibilities[1]);
        long num = Long.parseLong(n);
        long minDist = Long.MAX_VALUE;
        long ans = Long.MAX_VALUE;
        for(int i = 0; i < 5; i++) {
            if(Math.abs(num - possibilities[i]) != 0 && minDist >= Math.abs(num - possibilities[i])) {
                ans = Math.abs(num - possibilities[i]) != Math.abs(num - ans) ? possibilities[i] : (ans < possibilities[i] ? ans : possibilities[i]);
                minDist = Math.abs(num - possibilities[i]);
            }
        }
        return "" + ans;
    }
}