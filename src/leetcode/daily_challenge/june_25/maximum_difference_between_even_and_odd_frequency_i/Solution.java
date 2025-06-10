package leetcode.daily_challenge.june_25.maximum_difference_between_even_and_odd_frequency_i;

public class Solution {
    public int maxDifference(String s) {
		int[] count = new int[26];
		for(char c : s.toCharArray()) {
			count[(int)(c - 'a')]++;
        }
        int maxOddFreq = 0;
        int minEvenFreq = s.length();
        for(int n : count) {
            maxOddFreq = n % 2 == 1 ? Math.max(n, maxOddFreq) : maxOddFreq;
	        minEvenFreq = n > 0 &&  n % 2 == 0 ? Math.min(minEvenFreq, n) : minEvenFreq;

        }
        return maxOddFreq - minEvenFreq;
    }
}
