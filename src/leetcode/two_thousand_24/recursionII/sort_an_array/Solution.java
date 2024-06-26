package leetcode.two_thousand_24.recursionII.sort_an_array;

import java.util.Arrays;

public class Solution {
    private int[] mergeSort(int[] input) {
        if (input.length <= 1) {
            return input;
        }

        int pivotIdx = input.length / 2;
        int[] leftSortedArray = mergeSort(Arrays.copyOfRange(input, 0, pivotIdx));
        int[] rightSortedArray = mergeSort(Arrays.copyOfRange(input, pivotIdx, input.length));
        int[] mergedArray = merge(leftSortedArray, rightSortedArray);
        return mergedArray;
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int leftItr = 0;
        int rightItr = 0;
        int mItr = 0;
        while (mItr < mergedArray.length) {
            if (leftItr >= leftArray.length && rightItr < rightArray.length) {
                mergedArray[mItr++] = rightArray[rightItr++];
            } else if (leftItr < leftArray.length && rightItr >= rightArray.length) {
                mergedArray[mItr++] = leftArray[leftItr++];
            } else {
                if (leftArray[leftItr] <= rightArray[rightItr]) {
                    mergedArray[mItr++] = leftArray[leftItr++];
                } else {
                    mergedArray[mItr++] = rightArray[rightItr++];
                }
            }
        }
        return mergedArray;
    }

    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }
}
