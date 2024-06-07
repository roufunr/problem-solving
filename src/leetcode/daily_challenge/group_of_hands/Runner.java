package leetcode.daily_challenge.group_of_hands;

public class Runner {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,4,7,8,5 };
        int groupSize = 3;
        new Solution().isNStraightHand(hand, groupSize);
    }
}
