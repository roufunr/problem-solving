package others.top_sort;

public class Runner {
    public static void main(String[] args) {
        System.out.println(new Solution().topSort(6, new int[][]{{5, 0}, {4, 0}, {5, 2}, {2, 3}, {3, 1}, {4, 1}}));
    }
}
