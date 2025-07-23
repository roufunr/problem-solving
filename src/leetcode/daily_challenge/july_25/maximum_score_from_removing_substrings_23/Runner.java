package leetcode.daily_challenge.july_25.maximum_score_from_removing_substrings_23;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabbaaxybbaabb";
        int x = 5;
        int y = 4;
        int result = solution.maximumGain(s, x, y);
        System.out.println("Maximum Gain: " + result); // Expected output: 9
    }
}
