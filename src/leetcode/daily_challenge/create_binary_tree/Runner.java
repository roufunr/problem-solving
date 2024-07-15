package leetcode.daily_challenge.create_binary_tree;

public class Runner {
    public static void main(String[] args) {
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        new Solution().createBinaryTree(descriptions);
    }
}
