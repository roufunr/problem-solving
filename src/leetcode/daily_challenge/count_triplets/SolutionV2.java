package leetcode.daily_challenge.count_triplets;

public class SolutionV2 {
    // n^2 solution
    // x1 ^ x2 ^ x3 = 0 means x1^x2 = x3
    public int countTriplets(int[] arr) {
        int tripletCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = 0;
            a ^= arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                a ^= arr[k];
                if (a == 0) {
                    tripletCount += (k - 1);
                }
            }
        }
        return tripletCount;
    }
}