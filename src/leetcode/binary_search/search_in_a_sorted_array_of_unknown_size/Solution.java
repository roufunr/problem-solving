package leetcode.binary_search.search_in_a_sorted_array_of_unknown_size;

public class Solution {
    //https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/1061/
    public int search(ArrayReader reader, int target) {
        int lowest = 0;
        int highest = 9999;
        while(lowest <= highest) {
            int mid = lowest + (highest - lowest) / 2;
            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) > target) {
                highest = mid - 1;
            } else {
                lowest = mid + 1;
            }
        }
        return -1;
    }
}
