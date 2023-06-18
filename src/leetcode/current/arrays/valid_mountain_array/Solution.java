package leetcode.current.arrays.valid_mountain_array;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
    private int getSlope(int a, int b) {
        if(a < b) {
            return  1;
        } else if (a == b) {
            return  0;
        } else {
            return  -1;
        }
    }
    public boolean validMountainArray(int[] arr) {
        if(arr.length <= 2) {
            return false;
        }
        int numberOfPick = 0;
        for(int i = 2; i < arr.length; i++) {
            int prevSlope = getSlope(arr[i-2],arr[i-1]);
            int newSlope = getSlope(arr[i-1],arr[i]);
            if(prevSlope < newSlope) {
                return false;
            } else if (prevSlope == 0 || newSlope == 0) {
                return false;
            } else if (prevSlope > newSlope) {
                numberOfPick++;
            }
        }
        return numberOfPick == 1;
    }
}
