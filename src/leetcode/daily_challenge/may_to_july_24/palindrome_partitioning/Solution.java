package leetcode.daily_challenge.may_to_july_24.palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> result;
    List<String> partitions;

    public boolean isPalindrome(String s, int startIdx, int endIdx) {
        int totalItr = (endIdx - startIdx + 1) / 2;
        for (int i = 0; i < totalItr; i++) {
            if (s.charAt(startIdx + i) != s.charAt(endIdx - i)) {
                return false;
            }
        }
        return true;
    }

    private void getAllPartition(String s, int startIdx) {
        if (startIdx >= s.length()) {
            List<String> copiedPartition = new ArrayList<>();
            for (String ptr : partitions) {
                copiedPartition.add(ptr);
            }
            result.add(copiedPartition);
            return;
        }
        for (int j = startIdx; j < s.length(); j++) {
            if (isPalindrome(s, startIdx, j)) {
                partitions.add(s.substring(startIdx, j + 1));
                getAllPartition(s, j + 1);
                if (partitions.size() >= 1)
                    partitions.remove(partitions.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        partitions = new ArrayList<>();
        getAllPartition(s, 0);
        return result;
    }
}
