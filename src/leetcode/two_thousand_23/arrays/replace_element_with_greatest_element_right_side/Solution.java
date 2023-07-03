package leetcode.two_thousand_23.arrays.replace_element_with_greatest_element_right_side;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0; i--) {
            int element = arr[i];
            arr[i] = max;
            max = max < element ? element : max;
        }
        return arr;
    }
}
