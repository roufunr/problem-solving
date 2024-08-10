package lc_others.partition_string_into_minimum_beautiful_substrings;

import java.util.*;

public class Solution {
    private int minPartition = Integer.MAX_VALUE;
    private String s;
    private Set<String> power5;

    private void doPartition(int idx, int beginIdx, Set<Integer> partitionIndices) {
        if (idx == s.length()) {
            if (beginIdx == s.length()) {
                minPartition = Math.min(minPartition, partitionIndices.size());
            }
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (power5.contains(s.substring(beginIdx, i + 1))) {
                partitionIndices.add(beginIdx);
                doPartition(i + 1, i + 1, partitionIndices);
                partitionIndices.remove(beginIdx);
            } else {
                doPartition(i + 1, beginIdx, partitionIndices);
            }
        }
    }

    private void setPowerFive() {
        int i = 0;
        power5 = new HashSet<>();
        while (Math.pow(5, i) <= Math.pow(2, 15)) {
            String binString = Integer.toBinaryString((int) (Math.pow(5, i)));
            // System.out.println(binString);
            power5.add(binString);
            i++;
        }
    }

    public int minimumBeautifulSubstrings(String s) {
        this.s = s;
        this.setPowerFive();
        Set<Integer> partitionIndices = new HashSet<>();
        doPartition(0, 0, partitionIndices);
        return minPartition == Integer.MAX_VALUE ? -1 : minPartition;
    }
}