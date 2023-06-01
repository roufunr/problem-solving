package leetcode.binary_search.find_minimum_in_rotated_sorted_array;

public class Runner {
    public static void main(String[] args) {
        int[] arr =  {0, 1, 2, 3, 4, 5, 6};
        System.out.println(new Solution().findMin(arr));

        int[] arr1 =  {1, 2, 3, 4, 5, 6, 0};
        System.out.println(new Solution().findMin(arr1));

        int[] arr2 =  {5, 6, 0, 1, 2, 3, 4};
        System.out.println(new Solution().findMin(arr2));


        int[] arr3 =  {5};
        System.out.println(new Solution().findMin(arr3));

        int[] arr4 =  {6, 5};
        System.out.println(new Solution().findMin(arr4));
    }
}
