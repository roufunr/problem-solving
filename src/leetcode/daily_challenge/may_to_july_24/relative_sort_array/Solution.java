package leetcode.daily_challenge.may_to_july_24.relative_sort_array;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] count = new int[1001];
        for (int n : arr1) {
            count[n]++;
        }
        int k = 0;
        for (int n : arr2) {
            for (int i = 0; i < count[n]; i++) {
                ans[k++] = n;
            }
            count[n] = 0;
        }
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j < count[i]; j++) {
                ans[k++] = i;
            }
        }
        return ans;
    }
}