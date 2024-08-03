package leetcode.daily_challenge.august_24.make_two_arrays_equal;

public class SolutionII {
    // much better solution
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        for (int i = 0; i < target.length; i++) {
            count[target[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i]] == 0) {
                return false;
            } else {
                count[arr[i]]--;
            }
        }
        return true;
    }
}