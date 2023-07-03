package leetcode.two_thousand_23.beginners_guide.number_of_steps_to_reduce_a_number_to_zero;

public class Solution {
    // https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            num = num % 2 == 0 ? (num / 2) : (num - 1);
            steps++;
        }
        return steps;
    }
}
