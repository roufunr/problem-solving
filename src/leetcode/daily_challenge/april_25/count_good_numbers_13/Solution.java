package leetcode.daily_challenge.april_25.count_good_numbers_13;

public class Solution {
    private final long modulo = 1000 * 1000 * 1000 + 7;

    private long bigMod(long a, long b, long m) {
        // a^b % m = ? 
        long result = 1;
        while(b > 0) {
            if(b % 2 == 1) {
                result = (result * a) % m;
            }
            a = (a * a) % m;
            b = b / 2;
        }
        return result;

    }
    public int countGoodNumbers(long n) {
        long exp4 = (n/2);
        long exp5 = (n/2);
        if(n % 2 == 1) {
            exp5 += 1;
        } 
        long bigMod4 = bigMod(4, exp4, modulo);
        long bigMod5 = bigMod(5, exp5, modulo);
        return (int)((bigMod4 * bigMod5) % modulo);
    }
}
