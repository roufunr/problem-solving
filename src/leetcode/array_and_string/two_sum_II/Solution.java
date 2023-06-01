package leetcode.array_and_string.two_sum_II;

public class Solution {
    public int binarySearch(int[] numbers, int item) {
        int startIdx = 0;
        int endIdx = numbers.length - 1;
        int midIdx = (startIdx + endIdx) / 2;
        do {
            if(numbers[midIdx] == item) {
                return midIdx;
            } else if(item < numbers[midIdx]) {
                endIdx = midIdx - 1;
            } else if(item > numbers[midIdx]) {
                startIdx = midIdx + 1;
            }
            midIdx =(startIdx + endIdx) / 2;
        } while(startIdx <= endIdx);
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        //https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1153/
        int[] solution = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            int rest = target - numbers[i];
            int searchedIdx = binarySearch(numbers, rest);
            if(searchedIdx != -1 && searchedIdx != i) {
                solution[0] = Math.min(i,searchedIdx) + 1 ;
                solution[1] = Math.max(i,searchedIdx) + 1;
                break;
            }
        }
        return solution;
    }
}
