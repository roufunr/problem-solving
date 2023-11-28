package leetcode.two_thousand_23.binary_search.find_smallest_letter_greater_than_target;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target && letters[mid + 1] > target) {
                return letters[mid + 1];
            } else if (letters[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (letters[left] <= target && letters[left + 1] > target) {
            return letters[left + 1];
        }

        if (letters[right] <= target && right + 1 < letters.length && letters[right + 1] > target) {
            return letters[right + 1];
        }

        return letters[0];
    }
}
