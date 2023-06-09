package leetcode.current.arrays.max_consecutive_ones;

public class Runner {
    public static void main(String[] args) {
        int[] arr ={1,1,1,0,0,0,0,1,1,1,0,1};
        System.out.println(new Solution().findMaxConsecutiveOnes(arr));
    }
}
