package leetcode.hash_table.top_k_frequent_element;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3,3,3,3,4,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6};
        int k = 2;
        new Solution().topKFrequent(arr, k);
    }
}
