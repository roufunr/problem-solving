package leetcode.daily_challenge.august_25.rearranging_fruits_02;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] basket1 = {1, 2, 3};
        int[] basket2 = {3, 2, 1};
        System.out.println("Test Case 1: " + solution.minCost(basket1, basket2)); // Expected output: 0
        
        // Test case 2
        int[] basket3 = {1, 2, 3, 4};
        int[] basket4 = {4, 3, 2, 1};
        System.out.println("Test Case 2: " + solution.minCost(basket3, basket4)); // Expected output: 0
        
        // Test case 3
        int[] basket5 = {1, 2, 3};
        int[] basket6 = {4, 5, 6};
        System.out.println("Test Case 3: " + solution.minCost(basket5, basket6)); // Expected output: -1
        
        // Test case with duplicates
        int[] basket7 = {1, 1, 2};
        int[] basket8 = {2, 2, 1};
        System.out.println("Test Case with Duplicates: " + solution.minCost(basket7, basket8)); // Expected output: -1
    }
}
