package leetcode.two_thousand_23.binary_search.find_k_closest_elements;


public class Runner {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,4,5,5};
        int k = 3;
        int x = 3;
        new Solution().findClosestElements(arr, k, x);
    }
}
