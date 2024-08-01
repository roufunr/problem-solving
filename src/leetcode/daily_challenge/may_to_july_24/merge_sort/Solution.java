package leetcode.daily_challenge.may_to_july_24.merge_sort;

import java.util.*;

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
            if (leftItr < leftArray.length && rightItr < rightArray.length) {
                if (leftArray[leftItr] <= rightArray[rightItr]) {
                    mergedArray[mItr++] = leftArray[leftItr++];
                } else {
                    mergedArray[mItr++] = rightArray[rightItr++];
                }
            } else if (leftItr >= leftArray.length && rightItr < rightArray.length) {
                mergedArray[mItr++] = rightArray[rightItr++];
            } else if (leftItr < leftArray.length && rightItr >= rightArray.length) {
                mergedArray[mItr++] = leftArray[leftItr++];
            }
        }
        return mergedArray;
    }

    public int[] sortArray(int[] nums) {
        nums = mergeSort(nums);
        return nums;
    }
}