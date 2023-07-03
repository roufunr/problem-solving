package leetcode.two_thousand_23.arrays.squares_of_sorted_array;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
    private int findMaxNegativeIdx(int[] nums) {
        int negIdx = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >=  0) {
                break;
            } else {
                negIdx = i;
            }
        }
        negIdx = (negIdx == Integer.MIN_VALUE) ? 0 : negIdx;
        return negIdx;
    }
    private void squareAndReverseNegativeArray(int[] nums, int negIdx) {
        for(int i = 0; i <= (negIdx/2); i++) {
            int temp = nums[i] * nums[i];
            nums[i] =  nums[negIdx - i] * nums[negIdx - i];
            nums[negIdx - i] = temp;
        }
    }
    private void squareNonNegativeArray(int[] nums, int negIdx) {

        for(int i = negIdx + 1; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
    }
    private int[] mergeArray(int[] nums, int negIdx) {
        int[] mergedArray = new int[nums.length];
        int i = 0;
        int j = negIdx + 1;
        int k = 0;
        while(true) {
            if(i <= negIdx && j < nums.length) {
                mergedArray[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
            } else if (i > negIdx && j < nums.length) {
                mergedArray[k++] = nums[j++];
            } else if (i <= negIdx && j >= nums.length) {
                mergedArray[k++] = nums[i++];
            } else {
                break;
            }
        }
        return mergedArray;
    }
    public int[] sortedSquares(int[] nums) {
        int negIdx = findMaxNegativeIdx(nums);
        squareAndReverseNegativeArray(nums, negIdx);
        squareNonNegativeArray(nums, negIdx);
        return mergeArray(nums, negIdx);
    }
}
