package leetcode.two_thousand_23.binary_search.find_smallest_letter_greater_than_target;

public class Runner {
    public static void main(String[] args) {
        char[] letters = { 'e','e','e','e','e','e','n','n','n','n'};

        char target = 'e';
        new Solution().nextGreatestLetter(letters, target);

    }
}
