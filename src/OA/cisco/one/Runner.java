package OA.cisco.one;

public class Runner {
    public static void main(String[] args) {
        int[] tree = {30,20,15,25,24,40,37,45};
        int[] keys = {20, 40};
        new Solution().funcTreeDistance(tree, keys);
    }
}
