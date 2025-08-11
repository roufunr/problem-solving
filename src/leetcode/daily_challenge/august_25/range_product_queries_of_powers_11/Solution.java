package leetcode.daily_challenge.august_25.range_product_queries_of_powers_11;
import java.util.ArrayList;
import java.util.List;

public  class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        // Collect exponents of set bits in n (i.e., powers of two present in n)
        List<Integer> exps = new ArrayList<>();
        for (int bit = 0; n > 0; bit++, n >>= 1) {
            if ((n & 1) == 1) exps.add(bit);
        }

        // Prefix sum of exponents: ps[i] = sum of exps[0..i-1]
        int m = exps.size();
        long[] ps = new long[m + 1];
        for (int i = 0; i < m; i++) ps[i + 1] = ps[i] + exps.get(i);

        // Each query product = 2^(sum of exps in [l..r]) % MOD
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long power = ps[r + 1] - ps[l];
            ans[i] = (int) modPow2(power);
        }
        return ans;
    }

    // Computes 2^e % MOD
    private long modPow2(long e) {
        long base = 2, res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            e >>= 1;
        }
        return res;
    }
}