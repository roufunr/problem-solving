package leetcode.daily_challenge.april_25.count_good_triplets_14;

public class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int counter = 0;
        for(int i = 0; i < arr.length - 2; i++) {
            for(int j =  i + 1; j < arr.length - 1; j++) {
                for(int k = j + 1; k < arr.length; k++) {
                    int diffA = Math.abs(arr[i] - arr[j]);
                    int diffB = Math.abs(arr[j] - arr[k]);
                    int diffC = Math.abs(arr[i] - arr[k]);
                    if(diffA <= a && diffB <= b && diffC <= c) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}