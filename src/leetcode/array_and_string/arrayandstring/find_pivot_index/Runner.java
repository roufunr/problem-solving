package leetcode.array_and_string.arrayandstring.find_pivot_index;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,5,1,1,1,1};
        int i = new Solution().pivotIndex(arr);
        System.out.println(i);
    }
}
