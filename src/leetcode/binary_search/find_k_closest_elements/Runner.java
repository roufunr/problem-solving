package leetcode.binary_search.find_k_closest_elements;

public class Runner {
    public static void main(String[] args) {
        int[] arr ={0,0,0,1,3,5,6,7,8,8};
        int k = 2;
        int x = 2;

        new Solution().findClosestElements(arr, k, x);

    }
}
