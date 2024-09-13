package leetcode.top150.hindex_11;
import java.util.*;
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIdx = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] < hIdx + 1) {
                break;
            }
            hIdx++;
        }
        return hIdx;
    }
}