package leetcode.daily_challenge.january_25.find_the_prefix_common_array_of_two_arrays_14;

public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[A.length + 1];
        int[] ans = new int[A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
            freq[B[i]]++;
            if (A[i] == B[i]) {
                count++;
            } else {
                if (freq[A[i]] == 2) {
                    count++;
                }
                if (freq[B[i]] == 2) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
