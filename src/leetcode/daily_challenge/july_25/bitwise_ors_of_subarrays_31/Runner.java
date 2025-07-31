package leetcode.daily_challenge.july_25.bitwise_ors_of_subarrays_31;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {6, 3, 2, 1, 5};
        Solution solution = new Solution();
        int result = solution.subarrayBitwiseORs(arr);
        System.out.println("Number of unique bitwise ORs of all subarrays: " + result);
    }
}
