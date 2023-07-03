package leetcode.two_thousand_23.arrays.even_number_of_digits;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
    public int findNumbers(int[] nums) {
        int countEvenDigitsNumber = 0;
        for(int n : nums) {
            int digitCount = 0;
            while(n != 0) {
                n = n /10;
                digitCount++;
            }
            if (digitCount % 2 == 0) {
                countEvenDigitsNumber++;
            }
        }
        return countEvenDigitsNumber;
    }
}
