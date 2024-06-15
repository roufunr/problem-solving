package leetcode.extras.quicksort;

public class Runner {
    public static void main(String[] args) {

        int[] nums = {5,4,3,2,1};
        new Solution().quickSort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
