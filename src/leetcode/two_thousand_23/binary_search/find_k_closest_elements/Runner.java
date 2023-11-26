package leetcode.two_thousand_23.binary_search.find_k_closest_elements;

public class Runner {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 3;
        new Solution().findClosestElements(arr, k, x);
    }
}
