package leetcode.daily_challenge.count_triplets;

public class SolutionV1 {
    public int countTriplets(int[] arr) {
        int tripletCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = 0;
            for (int j = i + 1; j < arr.length; j++) {
                a ^= arr[j-1];
                int b = 0;
                for (int k = j; k < arr.length; k++) {
                    b ^= arr[k];
                    if(a == b) {
                        tripletCount++;
                    }
                }
            }
        }
        return tripletCount;
    }
}
