package leetcode.binary_search.find_smallest_letter_greater_than_target;

public class Solution {
	//https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while(left <= right) {
        	int mid = left + (right - left) / 2;
        	if(letters[mid] <= target) {
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        if(left >= letters.length) {
        	return letters[0];
        } else {
        	return letters[left];
        }
    }
}