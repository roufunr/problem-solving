package leetcode.two_thousand_23.arrays.check_if_N_and_its_double_exists;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
    public boolean checkIfExist(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if (j!=i && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
