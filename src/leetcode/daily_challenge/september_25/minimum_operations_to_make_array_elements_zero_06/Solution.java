package leetcode.daily_challenge.september_25.minimum_operations_to_make_array_elements_zero_06;

public class Solution {
    private int[] powerOfFour;
    public Solution() {
        powerOfFour = new int[16];
        for(int i = 0; i < 16; i++) {
            powerOfFour[i] = (int) Math.pow(4, i);
        }
    }
    public long calculateSumUptoN(int n) {
        int k = 0;
        long sum = 0;
        long addedItems = 0;
        long exponent = 1;
        while(exponent <= n) {
            sum += 3 * exponent * (k + 1);
            addedItems += 3 * exponent;
            exponent *= 4;
            k++;
        }
        long remainingItems = n - addedItems;
        sum += remainingItems * k;
        return sum;
    }
    public long minOperations(int[][] queries) {
        long sum = 0;
        for(int[] query : queries) {
            long leftSum = calculateSumUptoN(query[0] - 1);
            long rightSum = calculateSumUptoN(query[1]);
            // System.out.println(query[0] + ":" + leftSum + "---" + query[1] + ":" + rightSum);
            sum += (rightSum - leftSum + 1)/2;
        }
        return sum;
    }
}