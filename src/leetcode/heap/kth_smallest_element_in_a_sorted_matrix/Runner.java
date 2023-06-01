package leetcode.heap.kth_smallest_element_in_a_sorted_matrix;

public class Runner {
    public static void main(String[] args) {
        int[][] mat = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        for(int i = 0; i < 9; i++) {
            System.out.println(new Solution().kthSmallest(mat, i + 1));
        }
    }
}
