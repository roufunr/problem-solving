package leetcode.daily_challenge.september_24.xor_queries_of_a_subarray_13;

public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length];
        int xor = arr[0];
        prefix[0] = xor;
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
            prefix[i] = xor;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] - 1 >= 0)
                ans[i] = prefix[queries[i][1]] ^ prefix[queries[i][0] - 1];
            else
                ans[i] = prefix[queries[i][1]];
        }
        return ans;
    }
}