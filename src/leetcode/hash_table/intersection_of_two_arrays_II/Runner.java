package leetcode.hash_table.intersection_of_two_arrays_II;

public class Runner {
    public static void main(String[] args) {
        int[] n1 = {1,2,3,4,5,6,7,8,9,1,2,3,4,5};
        int[] n2 = {4,5,6,7,8,9,1,2,3,4,5};
        new Solution().intersect(n1, n2);
    }
}
