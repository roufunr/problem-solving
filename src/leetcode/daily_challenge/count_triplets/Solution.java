package leetcode.daily_challenge.count_triplets;

public class Solution { // solution 1 n^4
    public int countTriplets(int[] arr) {
        int tripletCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    int a = 0;
                    int b = 0;
                    for (int l = i; l < j; l++) {
                        a ^= arr[l];
                    }
                    for (int l = j; l <= k; l++) {
                        b ^= arr[l];
                    }
                    if (a == b) {
                        tripletCount++;
                    }
                }
            }
        }
        return tripletCount;
    }
}
