package leetcode.current.arrays.duplicate_zeros;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
    public void duplicateZeros(int[] arr) {
        int[] dupZeroArr = new int[arr.length];
        int i = 0;
        int j = 0;
        while(j < dupZeroArr.length) {
            if(arr[i] == 0) {
                dupZeroArr[j++] = 0;
                if(j < arr.length) dupZeroArr[j++] = 0;
            } else {
                dupZeroArr[j++] = arr[i];
            }
            i++;
        }
        for(i = 0; i < arr.length; i++) {
            arr[i] = dupZeroArr[i];
        }
    }
}
